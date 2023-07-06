package com.example.sportmaster;

import com.example.sportmaster.openapi.model.AnswerDTO;
import com.example.sportmaster.openapi.model.QuestionDTO;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

public interface IQuestionsService {

    public void deleteAnswer(Integer questionId, Integer answerId);

    public AnswerDoc findAnswer(Integer questionId, Integer answerId);

    public AnswerDoc updateAnswer(Integer questionId, Integer answerId, AnswerDoc answerDoc);

    public List<AnswerDoc> findAllAnswers(Integer questionId);

    public List<AnswerDoc> createAnswer(Integer questionId, AnswerDoc answerDoc);

    public void deleteQuestion(Integer questionId);

    public void updateQuestion(Integer questionId, QuestionDoc questionDoc);

    List<QuestionDoc> findAllQuestions(Integer quizId);
}
