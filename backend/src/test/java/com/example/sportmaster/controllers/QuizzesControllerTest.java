package com.example.sportmaster.controllers;

import com.example.sportmaster.models.QuestionData;
import com.example.sportmaster.repositories.interfaces.IQuestionsRepository;
import com.example.sportmaster.repositories.interfaces.IQuizzesRepository;
import com.example.sportmaster.services.interfaces.IQuestionsService;
import com.example.sportmaster.services.interfaces.IQuizzesService;
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
@WebMvcTest(QuizzesController.class)
class QuizzesControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IQuestionsRepository questionsRepository;
    @MockBean
    private IQuizzesRepository quizzesRepository;
    @MockBean
    private IQuizzesService quizzesService;
    @MockBean
    private IQuestionsService questionsService;

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
