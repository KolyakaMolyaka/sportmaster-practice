package com.example.sportmaster.service;

import com.example.sportmaster.repository.IQuizzesRepository;
import com.example.sportmaster.repository.QuizzesRepositoryImpl;
import com.example.sportmaster.repository.mappers.IQuestionDocToQuestionPerMapper;
import com.example.sportmaster.service.mappers.QuizDtoToQuizDocMapperImpl;
import com.example.sportmaster.service.models.QuestionDoc;
import com.example.sportmaster.service.models.QuizDoc;

public class DeleteQuizByIdQuestionByIdServiceImpl implements IDeleteQuizByIdQuestionByIdService {
    private final IQuizzesRepository quizzesRepository = new QuizzesRepositoryImpl();

    public boolean quizzesQuizIdQuestionsQuestionIdDelete(Integer quizId, Integer questionId) {
        return quizzesRepository.quizzesQuizIdQuestionsQuestionIdDelete(quizId, questionId);

    }

}
