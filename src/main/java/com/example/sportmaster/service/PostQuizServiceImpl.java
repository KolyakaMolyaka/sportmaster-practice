package com.example.sportmaster.service;

import com.example.sportmaster.repository.IQuizzesRepository;
import com.example.sportmaster.repository.QuizzesRepositoryImpl;
import com.example.sportmaster.repository.mappers.IQuizDocToQuizPerMapper;
import com.example.sportmaster.repository.mappers.QuizDocToQuizPerMapperImpl;
import com.example.sportmaster.service.models.QuizDoc;

public class PostQuizServiceImpl implements IPostQuizService {
    private final IQuizzesRepository quizzesRepository = new QuizzesRepositoryImpl();
    private final IQuizDocToQuizPerMapper quizDocToQuizPerMapper = new QuizDocToQuizPerMapperImpl();

    public QuizDoc quizzesPost(QuizDoc quiz) {
        return quizDocToQuizPerMapper.toQuizDoc(
                quizzesRepository.quizzesPost(quizDocToQuizPerMapper.toQuizPer(quiz))
        );

    }

}
