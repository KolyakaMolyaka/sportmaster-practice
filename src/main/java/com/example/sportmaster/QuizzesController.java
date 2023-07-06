package com.example.sportmaster;

import com.example.sportmaster.openapi.api.QuizzesApi;
import com.example.sportmaster.openapi.model.QuestionDTO;
import com.example.sportmaster.openapi.model.QuizDTO;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.InvalidKeyException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class QuizzesController implements QuizzesApi {
    @Autowired
    private IQuizzesService quizzesService;

    @Autowired
    private IQuestionsRepository questionsRepository;

    private IQuizDTOToQuizDocMapper quizDTOToQuizDocMapper = new QuizDTOToQuizDocMapper();

    @Override
    public ResponseEntity<List<QuizDTO>> quizzesGet() {
        List<QuizDTO> quizzes = new ArrayList<>();
        quizzesService.findAllQuizzes().stream()
                .map(quizDTOToQuizDocMapper::toQuizDTO).
                forEach(quizzes::add);

        if (quizzes.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(quizzes);
    }

    @Override
    public ResponseEntity<QuizDTO> quizzesPost(@ApiParam(value = "", required = true) @Valid @RequestBody QuizDTO quizDTO) {
        QuizDoc quizz = quizzesService.createQuiz(quizDTOToQuizDocMapper.toQuizDoc(quizDTO));
        return ResponseEntity.ok(quizz);
    }

    @Override
    public ResponseEntity<Void> quizzesQuizIdDelete(@ApiParam(value = "ID викторины", required = true) @PathVariable("quizId") Integer quizId) {
        try {
            quizzesService.deleteQuiz(quizId);
        } catch (InvalidKeyException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<QuizDTO> quizzesQuizIdGet(@ApiParam(value = "ID викторины", required = true) @PathVariable("quizId") Integer quizId) {
        QuizDoc quiz = quizzesService.findQuiz(quizId);
        if (quiz == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(quiz);
    }

    @Override
    public ResponseEntity<QuizDTO> quizzesQuizIdPut(@ApiParam(value = "ID викторины", required = true) @PathVariable("quizId") Integer quizId, @ApiParam(value = "", required = true) @Valid @RequestBody QuizDTO quizDTO) {
        try {
            QuizDoc quiz = quizzesService.updateQuiz(quizId, quizDTOToQuizDocMapper.toQuizDoc(quizDTO));
            return ResponseEntity.ok(quiz);
        } catch (InvalidKeyException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<List<QuestionDTO>> quizzesQuizIdQuestionsGet(@ApiParam(value = "ID викторины", required = true) @PathVariable("quizId") Integer quizId) {
        List<QuestionDTO> questions = questionsRepository.findAllQuestions(quizId);
        return ResponseEntity.internalServerError().build();
    }

    @Override
    public ResponseEntity<QuestionDTO> quizzesQuizIdQuestionsPost(@ApiParam(value = "ID викторины", required = true) @PathVariable("quizId") Integer quizId, @ApiParam(value = "", required = true) @Valid @RequestBody QuestionDTO questionDTO) {
        return ResponseEntity.internalServerError().build();
    }
}
