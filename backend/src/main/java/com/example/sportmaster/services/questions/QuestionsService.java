package com.example.sportmaster.services.questions;

import com.example.sportmaster.models.AnswerDoc;
import com.example.sportmaster.models.QuestionDoc;

import java.security.InvalidKeyException;
import java.util.List;

public interface QuestionsService {

    public void deleteAnswer(Integer questionId, Integer answerId);

    public AnswerDoc findAnswer(Integer questionId, Integer answerId);

    public AnswerDoc updateAnswer(Integer questionId, Integer answerId, AnswerDoc answerDoc);

    public List<AnswerDoc> findAllAnswers(Integer questionId);

    public List<AnswerDoc> createAnswer(Integer questionId, AnswerDoc answerDoc);

    public void deleteQuestion(Integer questionId) throws InvalidKeyException;

    public void updateQuestion(Integer questionId, QuestionDoc questionDoc) throws InvalidKeyException;

    List<QuestionDoc> findAllQuestions(Integer quizId);

    public QuestionDoc createQuestion(Integer quizId, QuestionDoc questionDoc) throws InvalidKeyException;

    void deleteForQuiz(Integer quizId);
}
