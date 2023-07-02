package com.example.sportmaster.service;

import com.example.sportmaster.service.models.QuizDoc;

public class PutQuizByIdServiceImpl implements IPutQuizByIdService {
    public QuizDoc quizzesQuizIdPut(Integer quizId, QuizDoc quiz) {
        // updating quiz, returning QuizDoc ..
        quiz.setDescription("updated description");
        return quiz;
    }

}
