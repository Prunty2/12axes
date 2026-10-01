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
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
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

    @Test
    void rejectsDuplicateIdsIncludingConflictingAnswers() throws Exception {
        for (String answer : List.of("NEUTRAL", "STRONGLY_AGREE")) {
            ObjectNode body = submission("short");
            ArrayNode answers = (ArrayNode) body.get("answers");
            // Keep the expected count: repeating one question must not replace another.
            answers.set(1, answers.get(0).deepCopy());
            ((ObjectNode) answers.get(1)).put("answer", answer);
            submit(body, false);
        }
    }

    @Test
    void rejectsMalformedEntries() throws Exception {
        String id = data.getQuestions().getFirst().id();
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
            ObjectNode body = submission("short");
            ((ArrayNode) body.get("answers")).set(0, mapper.readTree(entry));
            submit(body, false);
        }
    }

    @Test
    void rejectsMissingNullOrEmptyAnswerLists() throws Exception {
        submit(mapper.createObjectNode(), false);
        submit(mapper.createObjectNode().putNull("answers"), false);
        submit(mapper.createObjectNode().set("answers", mapper.createArrayNode()), false);
    }

    @Test
    void rejectsMissingAxisEvenWhenArchetypeSuppliesIt() throws Exception {
        ObjectNode body = submission("short");
        ArrayNode answers = (ArrayNode) body.get("answers");
        var missingIds = data.getQuestions().stream().filter(q -> q.axisId().equals("economia"))
                .map(Question::id).toList();
        for (int i = answers.size() - 1; i >= 0; i--) {
            if (missingIds.contains(answers.get(i).get("questionId").asText())) answers.remove(i);
        }
        body.putObject("archetype").put("economia", "F");
        submit(body, false);
    }

    @ParameterizedTest
    @ValueSource(strings = {"short", "extended", "extreme"})
    void rejectsIncompleteSubmissionsEvenWithEveryAxisPresent(String variant) throws Exception {
        ObjectNode body = submission(variant);
        ((ArrayNode) body.get("answers")).remove(0);
        submit(body, false);
    }

    @ParameterizedTest
    @ValueSource(strings = {"short", "extended"})
    void rejectsWrongDistributionWithCorrectTotal(String variant) throws Exception {
        ObjectNode body = submission(variant);
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
        submit(body, false);
    }

    @ParameterizedTest
    @ValueSource(strings = {"short", "extended"})
    void rejectsTooManyAnswers(String variant) throws Exception {
        ObjectNode body = submission("extreme");
        body.put("variant", variant);
        submit(body, false);
    }

    @ParameterizedTest
    @ValueSource(strings = {"short", "curta", "extended", "extensa", "extreme", "extrema", "240", "240questions"})
    void acceptsCompleteVariantsAndAliases(String variant) throws Exception {
        submit(submission(variant), true);
    }

    @Test
    void acceptsCompleteSubmissionWithDefaultVariant() throws Exception {
        ObjectNode body = submission("short");
        body.remove("variant");
        submit(body, true);
        body.putNull("variant");
        submit(body, true);
        body.put("variant", "  ");
        submit(body, true);
    }

    @ParameterizedTest
    @ValueSource(strings = {"invalid", "SHORTER"})
    void rejectsUnknownVariant(String variant) throws Exception {
        ObjectNode body = submission("short");
        body.put("variant", variant);
        submit(body, false);
    }

    private ObjectNode submission(String variant) {
        int perAxis = data.getQuiz(variant).questionsPerAxis();
        ObjectNode body = mapper.createObjectNode().put("variant", variant);
        ArrayNode answers = body.putArray("answers");
        data.getQuestions().stream().collect(Collectors.groupingBy(Question::axisId)).values().stream()
                .flatMap(group -> group.stream().limit(perAxis == 0 ? group.size() : perAxis))
                .forEach(q -> answers.addObject().put("questionId", q.id()).put("answer", "NEUTRAL"));
        return body;
    }

    private void submit(ObjectNode body, boolean valid) throws Exception {
        var result = mockMvc.perform(post("/api/results").contentType(MediaType.APPLICATION_JSON)
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
