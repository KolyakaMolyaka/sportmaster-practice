package com.example.sportmaster.service;

import com.example.sportmaster.openapi.model.QuizDTO;

public class PutQuizByIdServiceImpl implements IPutQuizByIdService {
    public QuizDoc quizzesQuizIdPut(Integer quizId, QuizDTO quiz) {
        // updating quiz, returning QuizDoc ..
        QuizDoc quizdoc = new QuizDoc();
        quizdoc.setDescription("updated description");
        return quizdoc;
    }

}
