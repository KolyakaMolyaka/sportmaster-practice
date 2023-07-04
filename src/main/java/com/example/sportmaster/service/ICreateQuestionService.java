package com.example.sportmaster.service;

import com.example.sportmaster.service.models.QuestionDoc;

public interface ICreateQuestionService {
    public QuestionDoc createQuestionForQuiz(Integer quizId, QuestionDoc question);
}
