package com.example.sportmaster.service;

import java.util.ArrayList;
import java.util.List;

public class GetQuizzesServiceImpl implements IGetQuizzesService {
    public List<QuizDoc> quizzesGet() {
        List<QuizDoc> stubQuizzes = new ArrayList<>();

        QuizDoc stubQuiz1 = new QuizDoc();
        stubQuiz1.setTitle("Stub title - quiz 1");
        stubQuiz1.setDescription("Stub description - quiz1");

        QuizDoc stubQuiz2 = new QuizDoc();
        stubQuiz2.setTitle("Stub title - quiz 2");
        stubQuiz2.setDescription("Stub description - quiz2");

        stubQuizzes.add(stubQuiz1);
        stubQuizzes.add(stubQuiz2);

        return stubQuizzes;
    }

}
