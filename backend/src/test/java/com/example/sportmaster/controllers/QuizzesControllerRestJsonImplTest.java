package com.example.sportmaster.controllers;

import com.example.sportmaster.models.QuestionData;
import com.example.sportmaster.repositories.interfaces.QuestionsRepository;
import com.example.sportmaster.repositories.interfaces.QuizzesRepository;
import com.example.sportmaster.services.questions.QuestionsService;
import com.example.sportmaster.services.quizzes.QuizzesService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(QuizzesControllerRestJsonImpl.class)
class QuizzesControllerRestJsonImplTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private QuestionsRepository questionsRepository;
    @MockBean
    private QuizzesRepository quizzesRepository;
    @MockBean
    private QuizzesService quizzesService;
    @MockBean
    private QuestionsService questionsService;

//    @Test
//    void quizzesGet() {
//    }
//
//    @Test
//    void quizzesPost() {
//    }
//
//    @Test
//    void quizzesQuizIdDelete() {
//    }
//
//    @Test
//    void quizzesQuizIdGet() {
//    }
//
//    @Test
//    void quizzesQuizIdPut() {
//    }
//
    @Test
    void quizzesQuizIdQuestionsGet() throws Exception {

        final Integer quizId = 1;
        when(questionsRepository.findAll(1))
                .thenReturn(Arrays.asList(
                                new QuestionData(1, quizId, "Question #1"),
                                new QuestionData(2, quizId, "Question #2")
                        )
                );
        mockMvc.perform(get("/quizzes/" + quizId + "/questions"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));

    }

//    @Test
//    void quizzesQuizIdQuestionsPost() {
//    }
}
