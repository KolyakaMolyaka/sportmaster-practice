package com.example.sportmaster.service;

import com.example.sportmaster.repository.IQuizzesRepository;
import com.example.sportmaster.repository.QuizzesRepositoryImpl;
import com.example.sportmaster.repository.mappers.IQuizDocToQuizPerMapper;
import com.example.sportmaster.repository.mappers.QuizDocToQuizPerMapperImpl;
import com.example.sportmaster.service.models.QuizDoc;

public class PutQuizByIdServiceImpl implements IPutQuizByIdService {

    private final IQuizzesRepository quizzesRepository = new QuizzesRepositoryImpl();
    private final IQuizDocToQuizPerMapper quizDocToQuizPerMapper = new QuizDocToQuizPerMapperImpl();
    public QuizDoc quizzesQuizIdPut(Integer quizId, QuizDoc quiz) {
        return quizDocToQuizPerMapper.toQuizDoc(
                quizzesRepository.quizzesQuizIdPut(quizId, quizDocToQuizPerMapper.toQuizPer(quiz))
        );
    }

}
