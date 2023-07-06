package com.example.sportmaster;

import com.example.sportmaster.openapi.model.QuestionDTO;

import java.util.List;

public interface IQuestionsRepository {
    public List<QuestionData> findAll(Integer quizId);

    QuestionData create(Integer quizId, QuestionData questionData);
}
