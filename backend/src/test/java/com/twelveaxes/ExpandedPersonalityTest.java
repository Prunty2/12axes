package com.twelveaxes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twelveaxes.service.QuizDataService;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class ExpandedPersonalityTest {
    private static final Map<String, String> ANSWERS = Map.of(
            "DT", "STRONGLY_DISAGREE", "D", "DISAGREE", "N", "NEUTRAL",
            "C", "AGREE", "CT", "STRONGLY_AGREE");

    @Autowired private MockMvc mockMvc;
    @Autowired private ObjectMapper mapper;
    @Autowired private QuizDataService dataService;

    @TestFactory
    List<DynamicTest> archivedAnswersProduceTheAddedPersonInBothLanguages() throws Exception {
        Path cwd = Path.of(System.getProperty("user.dir")).toAbsolutePath();
        Path root = Files.isDirectory(cwd.resolve("profile-audit")) ? cwd : cwd.getParent();
        JsonNode candidates = mapper.readTree(root.resolve("profile-audit/STATE.json").toFile())
                .path("personality").path("expansion").path("candidates");
        assertThat(candidates.isArray()).isTrue();
        List<DynamicTest> tests = new ArrayList<>();
        for (JsonNode candidate : candidates) {
            if (!candidate.path("status").asText().equals("added")) continue;
            String id = candidate.path("id").asText();
            tests.add(DynamicTest.dynamicTest(id, () -> {
                JsonNode archive = mapper.readTree(root.resolve(
                        "profile-audit/answers/personality/" + id + ".json").toFile());
                var request = mapper.createObjectNode().put("variant", "extreme");
                var answers = request.putArray("answers");
                for (var axis : dataService.getAxes()) {
                    archive.path(axis.id()).path("answers").fields().forEachRemaining(entry ->
                            answers.addObject().put("questionId", entry.getKey())
                                    .put("answer", ANSWERS.get(entry.getValue().asText())));
                }
                request.set("archetype", archive.path("archetype"));
                assertThat(answers.size()).isEqualTo(240);
                for (String lang : List.of("pt", "en")) {
                    var expected = dataService.getPersonalityById(id, lang);
                    JsonNode detail = mapper.readTree(mockMvc.perform(get("/api/personalities/" + id)
                                    .param("lang", lang)).andExpect(status().isOk())
                            .andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8));
                    assertThat(detail.path("name").asText()).isEqualTo(expected.name());
                    assertThat(detail.path("description").asText()).isEqualTo(expected.description());
                    JsonNode result = mapper.readTree(mockMvc.perform(post("/api/results")
                                    .param("lang", lang).contentType(MediaType.APPLICATION_JSON)
                                    .content(mapper.writeValueAsBytes(request)))
                            .andExpect(status().isOk()).andReturn().getResponse()
                            .getContentAsString(StandardCharsets.UTF_8));
                    assertThat(result.path("topPersonalityMatch").path("personalityId").asText()).isEqualTo(id);
                    assertThat(result.path("topPersonalityMatch").path("compatibility").asDouble()).isEqualTo(100.0);
                    for (JsonNode axis : result.path("axes")) {
                        assertThat(axis.path("leftPercent").asDouble()).isEqualTo(
                                dataService.getPersonalityProfiles().get(id).vector().get(axis.path("axisId").asText()));
                    }
                }
            }));
        }
        assertThat(tests).isNotEmpty();
        return tests;
    }
}
