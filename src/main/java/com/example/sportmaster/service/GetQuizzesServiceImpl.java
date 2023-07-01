package com.example.sportmaster.service;

import java.util.ArrayList;
import java.util.List;

public class GetQuizzesServiceImpl implements IGetQuizzesService {
    public List<QuizDoc> quizzesGet() {
        List<QuizDoc> stubQuizzes = new ArrayList<>();

        QuizDoc stubQuiz1 = new QuizDoc();
        stubQuiz1.title("Stub title - quiz 1");
        stubQuiz1.description("Stub description - quiz1");

        QuizDoc stubQuiz2 = new QuizDoc();
        stubQuiz2.title("Stub title - quiz 2");
        stubQuiz2.description("Stub description - quiz2");

        stubQuizzes.add(stubQuiz1);
        stubQuizzes.add(stubQuiz2);

        return stubQuizzes;
    }

}
