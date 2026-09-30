package com.twelveaxes;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.twelveaxes.model.Question;
import com.twelveaxes.service.QuizDataService;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class ResultSubmissionValidationTest {
    @Autowired private MockMvc mockMvc;
    @Autowired private ObjectMapper mapper;
    @Autowired private QuizDataService data;

    @ParameterizedTest
    @ValueSource(strings = {"/api/results", "/api/election/results"})
    void rejectsDuplicateIdsIncludingConflictingAnswers(String endpoint) throws Exception {
        for (String answer : List.of("NEUTRAL", "STRONGLY_AGREE")) {
            ObjectNode body = submission(endpoint, "short");
            ArrayNode answers = (ArrayNode) body.get("answers");
            // Keep the expected count: repeating one question must not replace another.
            answers.set(1, answers.get(0).deepCopy());
            ((ObjectNode) answers.get(1)).put("answer", answer);
            submit(endpoint, body, false);
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"/api/results", "/api/election/results"})
    void rejectsMalformedEntries(String endpoint) throws Exception {
        String id = questions(endpoint).getFirst().id();
        for (String entry : List.of(
                "null", "{}", "42", "[]", "\"NEUTRAL\"",
                "{\"answer\":\"NEUTRAL\"}",
                "{\"questionId\":null,\"answer\":\"NEUTRAL\"}",
                "{\"questionId\":\"  \",\"answer\":\"NEUTRAL\"}",
                "{\"questionId\":\"unknown\",\"answer\":\"NEUTRAL\"}",
                "{\"questionId\":\"%s\"}".formatted(id),
                "{\"questionId\":\"%s\",\"answer\":null}".formatted(id),
                "{\"questionId\":\"%s\",\"answer\":\"INVALID\"}".formatted(id),
                "{\"questionId\":\"%s\",\"answer\":true}".formatted(id),
                "{\"questionId\":\"%s\",\"answer\":{}}".formatted(id),
                "{\"questionId\":\"%s\",\"answer\":[]}".formatted(id),
                "{\"questionId\":\"%s\",\"answer\":0}".formatted(id),
                "{\"questionId\":\"%s\",\"answer\":\"0\"}".formatted(id))) {
            ObjectNode body = submission(endpoint, "short");
            ((ArrayNode) body.get("answers")).set(0, mapper.readTree(entry));
            submit(endpoint, body, false);
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"/api/results", "/api/election/results"})
    void rejectsMissingNullOrEmptyAnswerLists(String endpoint) throws Exception {
        submit(endpoint, mapper.createObjectNode(), false);
        submit(endpoint, mapper.createObjectNode().putNull("answers"), false);
        submit(endpoint, mapper.createObjectNode().set("answers", mapper.createArrayNode()), false);
    }

    @ParameterizedTest
    @ValueSource(strings = {"/api/results", "/api/election/results"})
    void rejectsMissingAxisEvenWhenArchetypeSuppliesIt(String endpoint) throws Exception {
        ObjectNode body = submission(endpoint, "short");
        ArrayNode answers = (ArrayNode) body.get("answers");
        var missingIds = questions(endpoint).stream().filter(q -> q.axisId().equals("economia"))
                .map(Question::id).toList();
        for (int i = answers.size() - 1; i >= 0; i--) {
            if (missingIds.contains(answers.get(i).get("questionId").asText())) answers.remove(i);
        }
        body.putObject("archetype").put("economia", "F");
        submit(endpoint, body, false);
    }

    @ParameterizedTest
    @CsvSource({"/api/results,short", "/api/results,extended", "/api/results,extreme",
            "/api/election/results,short"})
    void rejectsIncompleteSubmissionsEvenWithEveryAxisPresent(String endpoint, String variant) throws Exception {
        ObjectNode body = submission(endpoint, variant);
        ((ArrayNode) body.get("answers")).remove(0);
        submit(endpoint, body, false);
    }

    @ParameterizedTest
    @ValueSource(strings = {"short", "extended"})
    void rejectsWrongDistributionWithCorrectTotal(String variant) throws Exception {
        ObjectNode body = submission("/api/results", variant);
        ArrayNode answers = (ArrayNode) body.get("answers");
        String firstAxis = data.getQuestions().stream()
                .filter(q -> q.id().equals(answers.get(0).get("questionId").asText()))
                .findFirst().orElseThrow().axisId();
        var usedIds = new java.util.HashSet<String>();
        answers.forEach(a -> usedIds.add(a.get("questionId").asText()));
        Question replacement = data.getQuestions().stream()
                .filter(q -> !q.axisId().equals(firstAxis) && !usedIds.contains(q.id()))
                .findFirst().orElseThrow();
        ((ObjectNode) answers.get(0)).put("questionId", replacement.id());
        submit("/api/results", body, false);
    }

    @ParameterizedTest
    @ValueSource(strings = {"short", "extended"})
    void rejectsTooManyAnswers(String variant) throws Exception {
        ObjectNode body = submission("/api/results", "extreme");
        body.put("variant", variant);
        submit("/api/results", body, false);
    }

    @ParameterizedTest
    @ValueSource(strings = {"short", "curta", "extended", "extensa", "extreme", "extrema", "240", "240questions"})
    void acceptsCompleteVariantsAndAliases(String variant) throws Exception {
        submit("/api/results", submission("/api/results", variant), true);
    }

    @ParameterizedTest
    @ValueSource(strings = {"/api/results", "/api/election/results"})
    void acceptsCompleteSubmissionWithDefaultVariant(String endpoint) throws Exception {
        ObjectNode body = submission(endpoint, "short");
        body.remove("variant");
        submit(endpoint, body, true);
        body.putNull("variant");
        submit(endpoint, body, true);
        body.put("variant", "  ");
        submit(endpoint, body, true);
    }

    @ParameterizedTest
    @ValueSource(strings = {"/api/results", "/api/election/results"})
    void rejectsQuestionsFromTheOtherQuiz(String endpoint) throws Exception {
        ObjectNode body = submission(endpoint, "short");
        String other = endpoint.contains("election") ? "/api/results" : "/api/election/results";
        ((ObjectNode) body.get("answers").get(0)).put("questionId", questions(other).getFirst().id());
        submit(endpoint, body, false);
    }

    @ParameterizedTest
    @ValueSource(strings = {"invalid", "SHORTER"})
    void rejectsUnknownVariant(String variant) throws Exception {
        ObjectNode body = submission("/api/results", "short");
        body.put("variant", variant);
        submit("/api/results", body, false);
    }

    private List<Question> questions(String endpoint) {
        return endpoint.contains("election") ? data.getElectionQuestions() : data.getQuestions();
    }

    private ObjectNode submission(String endpoint, String variant) {
        int perAxis = endpoint.contains("election") ? 3 : data.getQuiz(variant).questionsPerAxis();
        ObjectNode body = mapper.createObjectNode().put("variant", variant);
        ArrayNode answers = body.putArray("answers");
        questions(endpoint).stream().collect(Collectors.groupingBy(Question::axisId)).values().stream()
                .flatMap(group -> group.stream().limit(perAxis == 0 ? group.size() : perAxis))
                .forEach(q -> answers.addObject().put("questionId", q.id()).put("answer", "NEUTRAL"));
        return body;
    }

    private void submit(String endpoint, ObjectNode body, boolean valid) throws Exception {
        var result = mockMvc.perform(post(endpoint).contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsBytes(body)));
        if (valid) {
            result.andExpect(status().isOk()).andExpect(jsonPath("$.axes.length()").value(12))
                    .andExpect(jsonPath("$.axes[*].leftPercent", org.hamcrest.Matchers.everyItem(
                            org.hamcrest.Matchers.is(50.0))));
        } else {
            result.andExpect(status().isBadRequest());
        }
    }
}
