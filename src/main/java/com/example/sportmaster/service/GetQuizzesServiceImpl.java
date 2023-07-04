package com.example.sportmaster.service;

import com.example.sportmaster.repository.IQuizzesRepository;
import com.example.sportmaster.repository.QuizzesRepositoryImpl;
import com.example.sportmaster.repository.mappers.IQuizDocToQuizPerMapper;
import com.example.sportmaster.repository.mappers.QuizDocToQuizPerMapperImpl;
import com.example.sportmaster.repository.models.QuizPer;
import com.example.sportmaster.service.models.QuizDoc;

import java.util.ArrayList;
import java.util.List;

public class GetQuizzesServiceImpl implements IGetQuizzesService {
    private final IQuizzesRepository quizzesRepository = new QuizzesRepositoryImpl();
    private final IQuizDocToQuizPerMapper quizDocToQuizPerMapper = new QuizDocToQuizPerMapperImpl();
    public List<QuizDoc> getQuizzes() {

        List<QuizPer> stubPerQuizzes = quizzesRepository.quizzesGet();
        List<QuizDoc> stubDocQuizzes = new ArrayList<>();
        for (QuizPer quizPer: stubPerQuizzes) {
            stubDocQuizzes.add(quizDocToQuizPerMapper.toQuizDoc(quizPer));
        }
        return stubDocQuizzes;
    }

}
