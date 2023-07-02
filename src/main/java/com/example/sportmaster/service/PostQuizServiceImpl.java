package com.example.sportmaster.service;

import com.example.sportmaster.openapi.model.QuizDTO;

public class PostQuizServiceImpl implements IPostQuizService {
    public QuizDoc quizzesPost(QuizDTO quiz) {
        // добавление QuizDTO, получение QuizDoc
        QuizDoc quizDoc = new QuizDoc();
        // изменение полей из QuizDTO
        quizDoc.setTitle(quiz.getTitle().toUpperCase());
        quizDoc.setDescription(quiz.getDescription().toUpperCase());

        return quizDoc;
    }

}
