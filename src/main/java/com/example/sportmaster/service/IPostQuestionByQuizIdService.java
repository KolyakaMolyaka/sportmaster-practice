package com.example.sportmaster.service;

import com.example.sportmaster.service.models.QuestionDoc;

public interface IPostQuestionByQuizIdService {
    public QuestionDoc quizzesQuizIdQuestionsPost(Integer quizId, QuestionDoc question);
}
