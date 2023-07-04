package com.example.sportmaster.service;

import com.example.sportmaster.repository.IQuizzesRepository;
import com.example.sportmaster.repository.QuizzesRepositoryImpl;

public class DeleteQuestionFromQuizServiceImpl implements IDeleteQuestionFromQuizService {
    private final IQuizzesRepository quizzesRepository = new QuizzesRepositoryImpl();

    public boolean deleteQuestionFromQuiz(Integer quizId, Integer questionId) {
        return quizzesRepository.deleteQuestion(quizId, questionId);

    }

}
