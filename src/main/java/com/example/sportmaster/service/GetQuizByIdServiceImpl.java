package com.example.sportmaster.service;

import com.example.sportmaster.repository.*;

public class GetQuizByIdServiceImpl implements IGetQuizByIdService {

    private final IQuizzesRepository quizzesRepository = new QuizzesRepositoryImpl();
    private final IQuizDocToQuizPerMapper quizDocToQuizPerMapper = new QuizDocToQuizPerMapperImpl();

    public QuizDoc quizzesQuizIdGet(Integer quizId) {
        return quizDocToQuizPerMapper.toQuizDoc(
                quizzesRepository.quizzesQuizIdGet(quizId)
        );
    }

}
