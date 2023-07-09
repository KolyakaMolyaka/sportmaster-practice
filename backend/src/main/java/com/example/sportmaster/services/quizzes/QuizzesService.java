package com.example.sportmaster.services.quizzes;

import com.example.sportmaster.models.QuizDoc;

import java.security.InvalidKeyException;
import java.util.List;

public interface QuizzesService {
    public List<QuizDoc> findAllQuizzes();

    public QuizDoc createQuiz(QuizDoc quizDoc);

    void deleteQuiz(Integer quizId) throws InvalidKeyException;

    QuizDoc findQuiz(Integer quizId);

    QuizDoc updateQuiz(Integer quizId, QuizDoc quizDoc) throws InvalidKeyException;
}
