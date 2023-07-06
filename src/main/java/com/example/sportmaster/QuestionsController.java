package com.example.sportmaster;

import com.example.sportmaster.openapi.api.QuestionsApi;
import com.example.sportmaster.openapi.model.AnswerDTO;
import com.example.sportmaster.openapi.model.QuestionDTO;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.InvalidKeyException;
import java.util.List;

@RestController
public class QuestionsController implements QuestionsApi {

    @Autowired
    IQuestionsService questionsService;

    @Override
    public ResponseEntity<Void> questionsQuestionIdAnswersAnswerIdDelete(@ApiParam(value = "ID вопроса", required = true) @PathVariable("questionId") Integer questionId, @ApiParam(value = "ID ответа", required = true) @PathVariable("answerId") Integer answerId) {
        return ResponseEntity.internalServerError().build();
    }

    @Override
    public ResponseEntity<AnswerDTO> questionsQuestionIdAnswersAnswerIdGet(@ApiParam(value = "ID вопроса", required = true) @PathVariable("questionId") Integer questionId, @ApiParam(value = "ID ответа", required = true) @PathVariable("answerId") Integer answerId) {
        return ResponseEntity.internalServerError().build();
    }

    @Override
    public ResponseEntity<AnswerDTO> questionsQuestionIdAnswersAnswerIdPut(@ApiParam(value = "ID вопроса", required = true) @PathVariable("questionId") Integer questionId, @ApiParam(value = "ID ответа", required = true) @PathVariable("answerId") Integer answerId, @ApiParam(value = "", required = true) @Valid @RequestBody AnswerDTO answerDTO) {
        return ResponseEntity.internalServerError().build();
    }

    @Override
    public ResponseEntity<List<AnswerDTO>> questionsQuestionIdAnswersGet(@ApiParam(value = "ID вопроса", required = true) @PathVariable("questionId") Integer questionId) {
        return ResponseEntity.internalServerError().build();
    }

    @Override
    public ResponseEntity<List<AnswerDTO>> questionsQuestionIdAnswersPost(@ApiParam(value = "ID вопроса", required = true) @PathVariable("questionId") Integer questionId, @ApiParam(value = "", required = true) @Valid @RequestBody AnswerDTO answerDTO) {
        return ResponseEntity.internalServerError().build();
    }

    @Override
    public ResponseEntity<Void> questionsQuestionIdDelete(@ApiParam(value = "ID вопроса", required = true) @PathVariable("questionId") Integer questionId) {
        try {
            questionsService.deleteQuestion(questionId);
        } catch (InvalidKeyException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> questionsQuestionIdPut(@ApiParam(value = "ID вопроса", required = true) @PathVariable("questionId") Integer questionId, @ApiParam(value = "", required = true) @Valid @RequestBody QuestionDTO questionDTO) {
        return ResponseEntity.internalServerError().build();
    }
}
