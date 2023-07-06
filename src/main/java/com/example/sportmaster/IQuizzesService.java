package com.example.sportmaster;

import java.security.InvalidKeyException;
import java.util.List;

public interface IQuizzesService {
    public List<QuizDoc> findAllQuizzes();

    public QuizDoc createQuiz(QuizDoc quizDoc);

    void deleteQuiz(Integer quizId) throws InvalidKeyException;

    QuizDoc findQuiz(Integer quizId);

    QuizDoc updateQuiz(Integer quizId, QuizDoc quizDoc) throws InvalidKeyException;
}
