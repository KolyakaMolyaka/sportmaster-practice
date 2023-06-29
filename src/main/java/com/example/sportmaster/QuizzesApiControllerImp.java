package com.example.sportmaster;

import com.example.openapi.api.QuizzesApi;
import com.example.openapi.api.QuizzesApiDelegate;
import com.example.openapi.model.Quiz;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuizzesApiControllerImp implements QuizzesApi {

    /* Пример реализации собственного метода */
    @Override
    public ResponseEntity<Quiz> quizzesQuizIdGet(@ApiParam(value = "ID викторины", required = true) @PathVariable("quizId") Integer quizId) {
        Quiz quiz = new Quiz();
        if (quizId == 1) {
            quiz.description("This is the first quiz");
        } else {
            quiz.description("This is not the first quiz :(");
        }
        return ResponseEntity.ok(quiz);
    }

}
