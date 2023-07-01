package com.example.sportmaster.service;

import com.example.sportmaster.openapi.model.QuizDTO;

public interface IPutQuizByIdService {
    public QuizDoc quizzesQuizIdPut(Integer quizId, QuizDTO quiz);
}
