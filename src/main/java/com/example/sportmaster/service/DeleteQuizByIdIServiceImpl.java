package com.example.sportmaster.service;

import com.example.sportmaster.repository.IQuizzesRepository;
import com.example.sportmaster.repository.QuizzesRepositoryImpl;

public class DeleteQuizByIdIServiceImpl implements IDeleteQuizService {
    private final IQuizzesRepository quizzesRepository = new QuizzesRepositoryImpl();
    public boolean deleteQuiz(Integer quizId) {
        return quizzesRepository.quizzesQuizIdDelete(quizId);
    }
}
