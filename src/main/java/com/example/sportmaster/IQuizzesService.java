package com.example.sportmaster;

import com.example.sportmaster.openapi.model.QuizDTO;

import java.util.List;

public interface IQuizzesService {
    public List<QuizDTO> findAllQuizzes();
}
