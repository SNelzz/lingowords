package nl.nielsdaalhuisen.lingowords;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.hamcrest.text.MatchesPattern.matchesPattern;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class LingowordsIntegrationTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Get all words complete layer test")
    void wordListGetAllWordsTest() throws Exception {
        mockMvc.perform(get("/words").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Get all words with 6 letters complete layer test")
    void wordListGetWordsSixLettersTest() throws Exception {
        mockMvc.perform(get("/words?size=6").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].value").exists())
                .andExpect(jsonPath("$.[0].value", matchesPattern("[a-z]{6}")));
    }

    @Test
    @DisplayName("Get single random word with 5 letters complete layer test")
    void wordListGetRandomWordFiveLettersTest() throws Exception {
        mockMvc.perform(get("/words/random?size=5").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.value").exists())
                .andExpect(jsonPath("$.value", matchesPattern("[a-z]{5}")));
    }
}
