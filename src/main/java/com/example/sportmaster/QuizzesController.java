package com.example.sportmaster;

import com.example.sportmaster.openapi.api.QuizzesApi;
import com.example.sportmaster.openapi.model.QuestionDTO;
import com.example.sportmaster.openapi.model.QuizDTO;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class QuizzesController implements QuizzesApi {
    @Override
    public ResponseEntity<List<QuizDTO>> quizzesGet() {
        return ResponseEntity.internalServerError().build();
    }

    @Override
    public ResponseEntity<QuizDTO> quizzesPost(@ApiParam(value = "", required = true) @Valid @RequestBody QuizDTO quizDTO) {
        return ResponseEntity.internalServerError().build();
    }

    @Override
    public ResponseEntity<Void> quizzesQuizIdDelete(@ApiParam(value = "ID викторины", required = true) @PathVariable("quizId") Integer quizId) {
        return ResponseEntity.internalServerError().build();
    }

    @Override
    public ResponseEntity<QuizDTO> quizzesQuizIdGet(@ApiParam(value = "ID викторины", required = true) @PathVariable("quizId") Integer quizId) {
        return ResponseEntity.internalServerError().build();
    }

    @Override
    public ResponseEntity<QuizDTO> quizzesQuizIdPut(@ApiParam(value = "ID викторины", required = true) @PathVariable("quizId") Integer quizId, @ApiParam(value = "", required = true) @Valid @RequestBody QuizDTO quizDTO) {
        return ResponseEntity.internalServerError().build();
    }

    @Override
    public ResponseEntity<List<QuestionDTO>> quizzesQuizIdQuestionsGet(@ApiParam(value = "ID викторины", required = true) @PathVariable("quizId") Integer quizId) {
        return ResponseEntity.internalServerError().build();
    }

    @Override
    public ResponseEntity<QuestionDTO> quizzesQuizIdQuestionsPost(@ApiParam(value = "ID викторины", required = true) @PathVariable("quizId") Integer quizId, @ApiParam(value = "", required = true) @Valid @RequestBody QuestionDTO questionDTO) {
        return ResponseEntity.internalServerError().build();
    }
}
