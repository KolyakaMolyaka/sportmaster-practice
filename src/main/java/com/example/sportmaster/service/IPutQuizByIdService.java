package com.example.sportmaster.service;

import com.example.sportmaster.service.models.QuizDoc;

public interface IPutQuizByIdService {
    public QuizDoc quizzesQuizIdPut(Integer quizId, QuizDoc quiz);
}
