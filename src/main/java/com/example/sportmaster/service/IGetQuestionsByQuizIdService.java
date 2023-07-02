package com.example.sportmaster.service;

import com.example.sportmaster.service.models.QuestionDoc;

import java.util.List;

public interface IGetQuestionsByQuizIdService {
    public List<QuestionDoc> quizzesQuizIdQuestionsGet(Integer quizId);
}
