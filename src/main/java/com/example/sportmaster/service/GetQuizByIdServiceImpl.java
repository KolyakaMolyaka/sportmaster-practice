package com.example.sportmaster.service;

public class GetQuizByIdServiceImpl implements IGetQuizByIdService {
    public QuizDoc quizzesQuizIdGet(Integer quizId) {
        QuizDoc quiz = new QuizDoc();
        if (quizId == 1) {
            quiz.description("This is the first quiz");
        } else {
            quiz.description("This is not the first quiz :(");
        }
        return quiz;
    }

}
