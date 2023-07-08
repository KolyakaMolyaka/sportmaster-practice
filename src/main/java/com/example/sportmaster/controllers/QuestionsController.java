package com.example.sportmaster.controllers;

import com.example.sportmaster.mappers.AnswerDTOToAnswerDocMapper;
import com.example.sportmaster.mappers.QuestionDTOToQuestionDocMapper;
import com.example.sportmaster.mappers.interfaces.IAnswerDTOToAnswerDocMapper;
import com.example.sportmaster.mappers.interfaces.IQuestionDTOToQuestionDocMapper;
import com.example.sportmaster.openapi.api.QuestionsApi;
import com.example.sportmaster.openapi.model.AnswerDTO;
import com.example.sportmaster.openapi.model.QuestionDTO;
import com.example.sportmaster.services.interfaces.IAnswersService;
import com.example.sportmaster.services.interfaces.IQuestionsService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.InvalidKeyException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class QuestionsController implements QuestionsApi {

    @Autowired
    private IQuestionsService questionsService;

    @Autowired
    private IAnswersService answersService;


    private IQuestionDTOToQuestionDocMapper questionDTOToQuestionDocMapper = new QuestionDTOToQuestionDocMapper();
    private IAnswerDTOToAnswerDocMapper answerDTOToAnswerDocMapper = new AnswerDTOToAnswerDocMapper();

    @Override
    public ResponseEntity<Void> questionsQuestionIdAnswersAnswerIdDelete(@ApiParam(value = "ID вопроса", required = true) @PathVariable("questionId") Integer questionId, @ApiParam(value = "ID ответа", required = true) @PathVariable("answerId") Integer answerId) {
        try {
            answersService.deleteAnswer(answerId);
        } catch (InvalidKeyException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.accepted().build();
    }

    @Override
    public ResponseEntity<AnswerDTO> questionsQuestionIdAnswersAnswerIdGet(@ApiParam(value = "ID вопроса", required = true) @PathVariable("questionId") Integer questionId, @ApiParam(value = "ID ответа", required = true) @PathVariable("answerId") Integer answerId) {
        AnswerDTO answer =  answerDTOToAnswerDocMapper.toAnswerDTO(answersService.getAnswer(questionId, answerId));
        if (answer == null) ResponseEntity.notFound().build();
        return ResponseEntity.ok(answer);
    }

    @Override
    public ResponseEntity<AnswerDTO> questionsQuestionIdAnswersAnswerIdPut(@ApiParam(value = "ID вопроса", required = true) @PathVariable("questionId") Integer questionId, @ApiParam(value = "ID ответа", required = true) @PathVariable("answerId") Integer answerId, @ApiParam(value = "", required = true) @Valid @RequestBody AnswerDTO answerDTO) {
        try {
            AnswerDTO answer = answerDTOToAnswerDocMapper.toAnswerDTO(
                    answersService.updateAnswer(questionId, answerId, answerDTOToAnswerDocMapper.toAnswerDoc(answerDTO))
            );
            return ResponseEntity.ok(answer);
        } catch (InvalidKeyException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<List<AnswerDTO>> questionsQuestionIdAnswersGet(@ApiParam(value = "ID вопроса", required = true) @PathVariable("questionId") Integer questionId) {
        List<AnswerDTO> answers = new ArrayList<>();
        try {
            answersService.findAllAnswers(questionId)
                    .stream()
                    .map(answerDTOToAnswerDocMapper::toAnswerDTO)
                    .forEach(answers::add);
        } catch (InvalidKeyException e) {
            return ResponseEntity.notFound().build();
        }
        if (answers.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(answers);
    }

    @Override
    public ResponseEntity<AnswerDTO> questionsQuestionIdAnswersPost(@ApiParam(value = "ID вопроса", required = true) @PathVariable("questionId") Integer questionId, @ApiParam(value = "", required = true) @Valid @RequestBody AnswerDTO answerDTO) {
        try {
            AnswerDTO answer = answerDTOToAnswerDocMapper.toAnswerDTO(
                    answersService.createAnswer(questionId, answerDTOToAnswerDocMapper.toAnswerDoc(answerDTO))
            );
            return ResponseEntity.ok(answer);
        } catch (InvalidKeyException e) {
            return ResponseEntity.notFound().build();
        }
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
        try {
            questionsService.updateQuestion(questionId, questionDTOToQuestionDocMapper.toQuestionDoc(questionDTO));
        } catch (InvalidKeyException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}
