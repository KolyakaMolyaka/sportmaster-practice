package com.example.sportmaster.repositories.questions;

import com.example.sportmaster.models.questions.QuestionData;

import java.security.InvalidKeyException;
import java.util.List;

public interface QuestionsRepository {
    public List<QuestionData> findAll(Integer quizId);

    QuestionData create(Integer quizId, QuestionData questionData);

    void delete(Integer questionId) throws InvalidKeyException;

    void update(Integer questionId, QuestionData questionData) throws InvalidKeyException;

    QuestionData find(Integer questionId);

    List<Integer> deleteQuestions(Integer quizId);
}
