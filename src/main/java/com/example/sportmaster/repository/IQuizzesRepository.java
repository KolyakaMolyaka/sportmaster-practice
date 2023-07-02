package com.example.sportmaster.repository;

import com.example.sportmaster.repository.models.QuizPer;

public interface IQuizzesRepository {
    public QuizPer quizzesQuizIdGet(Integer quizId);
    public boolean quizzesQuizIdDelete(Integer quizId);
}
