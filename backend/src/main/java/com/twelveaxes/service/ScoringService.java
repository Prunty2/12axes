package com.twelveaxes.service;

import com.twelveaxes.model.ArchetypeQuestion;
import com.twelveaxes.model.Axis;
import com.twelveaxes.model.AxisResult;
import com.twelveaxes.model.Pole;
import com.twelveaxes.model.Question;
import com.twelveaxes.model.QuizPayload;
import com.twelveaxes.model.ResultRequest;
import com.twelveaxes.model.SubmittedAnswer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ScoringService {
    private final QuizDataService dataService;

    public ScoringService(QuizDataService dataService) {
        this.dataService = dataService;
    }

    public List<AxisResult> score(ResultRequest request) {
        return score(request, QuizDataService.LANG_PT);
    }

    public List<AxisResult> score(ResultRequest request, String lang) {
        QuizPayload quiz = dataService.getQuiz(request.variant());
        Map<String, Question> questionById = quiz.questions().stream()
                .collect(Collectors.toMap(Question::id, Function.identity()));

        validateAnswers(request.answers(), questionById, quiz);

        Map<String, WeightedScore> scores = new HashMap<>();
        for (SubmittedAnswer submittedAnswer : request.answers()) {
            Question question = questionById.get(submittedAnswer.questionId());
            double towardAgreement = submittedAnswer.answer().scoreTowardAgreement();
            double leftScore = question.agreePole() == Pole.LEFT ? towardAgreement : 1.0 - towardAgreement;
            scores.computeIfAbsent(question.axisId(), ignored -> new WeightedScore())
                    .add(leftScore, question.weight());
        }
        addArchetypeAnswers(request.archetype(), scores);

        String normalizedLang = QuizDataService.normalizeLang(lang);
        return dataService.getAxes(normalizedLang).stream()
                .map(axis -> toAxisResult(axis, scores.get(axis.id()), normalizedLang))
                .toList();
    }
    public List<AxisResult> scoreElection(ResultRequest request) {
        QuizPayload quiz = dataService.getElectionQuiz();
        Map<String, Question> questions = quiz.questions().stream().collect(Collectors.toMap(Question::id, Function.identity()));
        validateAnswers(request.answers(), questions, quiz);
        Map<String, WeightedScore> scores = new HashMap<>();
        for (SubmittedAnswer answer : request.answers()) { Question q=questions.get(answer.questionId()); double left=q.agreePole()==Pole.LEFT ? answer.answer().scoreTowardAgreement() : 1-answer.answer().scoreTowardAgreement(); scores.computeIfAbsent(q.axisId(), x -> new WeightedScore()).add(left,q.weight()); }
        return dataService.getAxes(QuizDataService.LANG_PT).stream().map(axis -> toAxisResult(axis,scores.get(axis.id()),QuizDataService.LANG_PT)).toList();
    }

    // Reconstrói o resultado a partir de um vetor de leftPercent (um valor por
    // eixo, na ordem de axes.json) — usado pelas URLs de resultado compartilhado.
    public List<AxisResult> scoreFromLeftPercents(List<Double> leftPercents, String lang) {
        String normalizedLang = QuizDataService.normalizeLang(lang);
        List<Axis> axes = dataService.getAxes(normalizedLang);
        if (leftPercents.size() != axes.size()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Vetor de eixos inválido: esperados " + axes.size() + " valores"
            );
        }
        return java.util.stream.IntStream.range(0, axes.size())
                .mapToObj(index -> buildAxisResult(axes.get(index), leftPercents.get(index), normalizedLang))
                .toList();
    }

    // Cada alternativa escolhida entra como uma resposta a mais em cada eixo que
    // ela toca, com o mesmo peso (1) de uma pergunta comum.
    private void addArchetypeAnswers(Map<String, String> choices, Map<String, WeightedScore> scores) {
        if (choices == null || choices.isEmpty()) {
            return;
        }
        Map<String, ArchetypeQuestion> byId = dataService.getArchetypeQuestions().stream()
                .collect(Collectors.toMap(ArchetypeQuestion::id, Function.identity()));
        choices.forEach((questionId, optionId) -> {
            ArchetypeQuestion question = byId.get(questionId);
            ArchetypeQuestion.Option option = question == null ? null : question.options().stream()
                    .filter(candidate -> candidate.id().equals(optionId))
                    .findFirst()
                    .orElse(null);
            if (option == null) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "Resposta de arquétipo inválida: " + questionId + "=" + optionId
                );
            }
            option.effects().forEach((axisId, leftPercent) ->
                    scores.computeIfAbsent(axisId, ignored -> new WeightedScore()).add(leftPercent / 100.0, 1.0));
        });
    }

    private void validateAnswers(List<SubmittedAnswer> answers, Map<String, Question> questionById, QuizPayload quiz) {
        if (answers == null || answers.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Respostas obrigatórias");
        }
        Set<String> seen = new HashSet<>();
        Map<String, Integer> countsByAxis = new HashMap<>();
        for (SubmittedAnswer answer : answers) {
            if (answer == null || answer.questionId() == null || answer.questionId().isBlank()
                    || answer.answer() == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Resposta inválida: questionId e answer obrigatórios");
            }
            Question question = questionById.get(answer.questionId());
            if (question == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID de pergunta desconhecido: " + answer.questionId());
            }
            if (!seen.add(answer.questionId())) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID de pergunta duplicado: " + answer.questionId());
            }
            countsByAxis.merge(question.axisId(), 1, Integer::sum);
        }

        // Validate base answers before archetypes; optional choices cannot fill missing axes.
        for (Axis axis : quiz.axes()) {
            int expected = quiz.questionsPerAxis() == 0
                    ? (int) questionById.values().stream().filter(q -> q.axisId().equals(axis.id())).count()
                    : quiz.questionsPerAxis();
            if (countsByAxis.getOrDefault(axis.id(), 0) != expected) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "Submissão inválida: esperadas " + expected + " respostas no eixo " + axis.id());
            }
        }
        if (answers.size() != quiz.questionCount()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Submissão inválida: esperadas " + quiz.questionCount() + " respostas"
            );
        }
    }

    private AxisResult toAxisResult(Axis axis, WeightedScore weightedScore, String lang) {
        return buildAxisResult(axis, weightedScore.average() * 100.0, lang);
    }

    private AxisResult buildAxisResult(Axis axis, double rawLeftPercent, String lang) {
        double leftPercent = round(Math.max(0.0, Math.min(100.0, rawLeftPercent)));
        double rightPercent = round(100.0 - leftPercent);
        String dominantPole = leftPercent >= rightPercent ? axis.leftPole() : axis.rightPole();
        double distanceFromCenter = Math.abs(leftPercent - 50.0);
        String intensity = intensityFor(distanceFromCenter, lang);
        return new AxisResult(
                axis.id(),
                axis.label(),
                axis.leftPole(),
                axis.rightPole(),
                leftPercent,
                rightPercent,
                dominantPole,
                intensity
        );
    }

    private String intensityFor(double distanceFromCenter, String lang) {
        boolean en = QuizDataService.LANG_EN.equals(lang);
        if (distanceFromCenter < 7.5) {
            return en ? "Balanced" : "Equilibrado";
        }
        if (distanceFromCenter < 22.5) {
            return en ? "Leaning" : "Inclinado";
        }
        if (distanceFromCenter < 37.5) {
            return en ? "Strong" : "Forte";
        }
        return en ? "Very strong" : "Muito forte";
    }

    private double round(double value) {
        return Math.round(value * 10.0) / 10.0;
    }

    private static final class WeightedScore {
        private double total;
        private double weight;

        void add(double score, double itemWeight) {
            total += score * itemWeight;
            weight += itemWeight;
        }

        double average() {
            return weight == 0.0 ? 0.5 : total / weight;
        }
    }
}
