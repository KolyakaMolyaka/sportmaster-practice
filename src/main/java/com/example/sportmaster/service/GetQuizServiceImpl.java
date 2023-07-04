package com.example.sportmaster.service;

import com.example.sportmaster.repository.*;
import com.example.sportmaster.repository.mappers.IQuizDocToQuizPerMapper;
import com.example.sportmaster.repository.mappers.QuizDocToQuizPerMapperImpl;
import com.example.sportmaster.service.models.QuizDoc;

public class GetQuizServiceImpl implements IGetQuizService {

    private final IQuizzesRepository quizzesRepository = new QuizzesRepositoryImpl();
    private final IQuizDocToQuizPerMapper quizDocToQuizPerMapper = new QuizDocToQuizPerMapperImpl();

    public QuizDoc getQuiz(Integer quizId) {
        return quizDocToQuizPerMapper.toQuizDoc(
                quizzesRepository.quizzesQuizIdGet(quizId)
        );
    }

}
