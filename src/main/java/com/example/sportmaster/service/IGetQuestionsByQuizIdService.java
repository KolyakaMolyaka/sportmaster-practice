package com.example.sportmaster.service;

import java.util.List;

public interface IGetQuestionsByQuizIdService {
    public List<QuestionDoc> quizzesQuizIdQuestionsGet(Integer quizId);
}
