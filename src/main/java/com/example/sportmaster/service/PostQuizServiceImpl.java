package com.example.sportmaster.service;

import com.example.sportmaster.openapi.model.QuizDTO;

public class PostQuizServiceImpl implements IPostQuizService {
    public QuizDoc quizzesPost(QuizDoc quiz) {
        // добавление QuizDTO, получение QuizDoc
        // изменение полей из QuizDTO
        quiz.setTitle(quiz.getTitle().toUpperCase());
        quiz.setDescription(quiz.getDescription().toUpperCase());

        return quiz;
    }

}
