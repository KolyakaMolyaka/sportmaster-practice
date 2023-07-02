package com.example.sportmaster.service;

import com.example.sportmaster.openapi.model.QuizDTO;

public interface IPostQuizService {
    public QuizDoc quizzesPost(QuizDoc quiz);
}
