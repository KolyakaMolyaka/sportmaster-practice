package com.example.sportmaster.controllers;

import com.example.sportmaster.mappers.QuestionDTOToQuestionDocMapper;
import com.example.sportmaster.mappers.QuizDTOToQuizDocMapper;
import com.example.sportmaster.mappers.interfaces.IQuestionDTOToQuestionDocMapper;
import com.example.sportmaster.mappers.interfaces.IQuizDTOToQuizDocMapper;
import com.example.sportmaster.openapi.api.QuizzesApi;
import com.example.sportmaster.openapi.model.QuestionDTO;
import com.example.sportmaster.openapi.model.QuizDTO;
import com.example.sportmaster.services.interfaces.IQuestionsService;
import com.example.sportmaster.services.interfaces.IQuizzesService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.InvalidKeyException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class QuizzesController implements QuizzesApi {

    /* севисы */
    @Autowired
    private IQuizzesService quizzesService;

    @Autowired
    private IQuestionsService questionsService;

    /* мапперы */
    private IQuizDTOToQuizDocMapper quizDTOToQuizDocMapper = new QuizDTOToQuizDocMapper();
    private IQuestionDTOToQuestionDocMapper questionDTOToQuestionDocMapper = new QuestionDTOToQuestionDocMapper();


    /* API */

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
        QuizDTO quiz = quizDTOToQuizDocMapper.toQuizDTO(quizzesService.createQuiz(quizDTOToQuizDocMapper.toQuizDoc(quizDTO)));
        return ResponseEntity.ok(quiz);
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
        QuizDTO quiz = quizDTOToQuizDocMapper.toQuizDTO(quizzesService.findQuiz(quizId));
        if (quiz == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(quiz);
    }

    @Override
    public ResponseEntity<QuizDTO> quizzesQuizIdPut(@ApiParam(value = "ID викторины", required = true) @PathVariable("quizId") Integer quizId, @ApiParam(value = "", required = true) @Valid @RequestBody QuizDTO quizDTO) {
        try {
            QuizDTO quiz = quizDTOToQuizDocMapper.toQuizDTO(quizzesService.updateQuiz(quizId, quizDTOToQuizDocMapper.toQuizDoc(quizDTO)));
            return ResponseEntity.ok(quiz);
        } catch (InvalidKeyException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<List<QuestionDTO>> quizzesQuizIdQuestionsGet(@ApiParam(value = "ID викторины", required = true) @PathVariable("quizId") Integer quizId) {
        List<QuestionDTO> questions = new ArrayList<>();
        questionsService.findAllQuestions(quizId)
                .stream()
                .map(questionDTOToQuestionDocMapper::toQuestionDTO)
                .forEach(questions::add);

        if (questions.isEmpty()) {
            ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(questions);
    }

    @Override
    public ResponseEntity<QuestionDTO> quizzesQuizIdQuestionsPost(@ApiParam(value = "ID викторины", required = true) @PathVariable("quizId") Integer quizId, @ApiParam(value = "", required = true) @Valid @RequestBody QuestionDTO questionDTO) {
        try {
            QuestionDTO question = questionDTOToQuestionDocMapper.toQuestionDTO(
                    questionsService.createQuestion(quizId, questionDTOToQuestionDocMapper.toQuestionDoc(questionDTO))
            );
            return ResponseEntity.ok(question);
        } catch (InvalidKeyException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
