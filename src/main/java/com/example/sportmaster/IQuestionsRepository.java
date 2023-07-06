package com.example.sportmaster;

import com.example.sportmaster.openapi.model.QuestionDTO;

import java.security.InvalidKeyException;
import java.util.List;

public interface IQuestionsRepository {
    public List<QuestionData> findAll(Integer quizId);

    QuestionData create(Integer quizId, QuestionData questionData);

    void delete(Integer questionId) throws InvalidKeyException;

    void update(Integer questionId, QuestionData questionData) throws InvalidKeyException;
}
