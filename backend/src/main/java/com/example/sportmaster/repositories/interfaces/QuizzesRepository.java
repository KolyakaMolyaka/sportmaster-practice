package com.example.sportmaster.repositories.interfaces;


import com.example.sportmaster.models.QuizData;

import java.security.InvalidKeyException;
import java.util.List;

public interface QuizzesRepository {
    public  List<QuizData> findAll();
    public QuizData create(QuizData quizData);

    void delete(Integer quizId) throws InvalidKeyException;

    QuizData find(Integer quizId);

    QuizData update(Integer quizId, QuizData quizData) throws InvalidKeyException;
}
