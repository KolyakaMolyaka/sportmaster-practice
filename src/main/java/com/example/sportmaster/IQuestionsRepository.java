package com.example.sportmaster;

import com.example.sportmaster.openapi.model.QuestionDTO;

import java.util.List;

public interface IQuestionsRepository {
    List<QuestionDTO> findAllQuestions(Integer quizId);
}
