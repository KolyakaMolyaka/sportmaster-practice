package com.example.sportmaster.service;

public class PostQuizServiceImpl implements IPostQuizService {
    public QuizDoc quizzesPost(QuizDoc quiz) {
        // изменение полей из QuizDTO
        quiz.setTitle(quiz.getTitle().toUpperCase());
        quiz.setDescription(quiz.getDescription().toUpperCase());

        return quiz;
    }

}
