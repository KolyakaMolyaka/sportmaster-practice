package com.example.sportmaster.service;

import com.example.sportmaster.openapi.model.QuestionDTO;

public interface IPostQuestionByQuizIdService {
    public QuestionDoc quizzesQuizIdQuestionsPost(Integer quizId, QuestionDoc question);
}
