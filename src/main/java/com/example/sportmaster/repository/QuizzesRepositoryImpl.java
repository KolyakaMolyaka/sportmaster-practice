package com.example.sportmaster.repository;

import com.example.sportmaster.repository.models.QuizPer;

public class QuizzesRepositoryImpl implements IQuizzesRepository {
    public QuizPer quizzesQuizIdGet(Integer quizId) {
        QuizPer quiz = new QuizPer();
        if (quizId == 1) {
            quiz.setDescription("This is the first quiz");
        } else {
            quiz.setDescription("This is not the first quiz :(");
        }
        return quiz;

    }

    public boolean quizzesQuizIdDelete(Integer quizId) {
        // deleting quiz
        boolean deleteOperation = false;
        if (1 == quizId) deleteOperation = true;
        return deleteOperation;
    }
}
