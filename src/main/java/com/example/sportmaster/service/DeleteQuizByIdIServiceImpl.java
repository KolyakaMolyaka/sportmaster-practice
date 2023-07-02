package com.example.sportmaster.service;

import com.example.sportmaster.repository.IQuizzesRepository;
import com.example.sportmaster.repository.QuizzesRepositoryImpl;

public class DeleteQuizByIdIServiceImpl implements IDeleteQuizByIdService {
    private final IQuizzesRepository quizzesRepository = new QuizzesRepositoryImpl();
    public boolean quizzesQuizIdDelete(Integer quizId) {
        return quizzesRepository.quizzesQuizIdDelete(quizId);
    }
}
