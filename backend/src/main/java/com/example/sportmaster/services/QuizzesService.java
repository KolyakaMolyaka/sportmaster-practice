package com.example.sportmaster.services;

import com.example.sportmaster.repositories.interfaces.IQuestionsRepository;
import com.example.sportmaster.repositories.interfaces.IQuizzesRepository;
import com.example.sportmaster.models.QuizDoc;
import com.example.sportmaster.mappers.QuizDocToQuizDataMapper;
import com.example.sportmaster.mappers.interfaces.IQuizDocToQuizDataMapper;
import com.example.sportmaster.services.interfaces.IQuestionsService;
import com.example.sportmaster.services.interfaces.IQuizzesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidKeyException;
import java.util.List;

@Service
public class QuizzesService implements IQuizzesService {
    @Autowired
    private IQuizzesRepository quizzesRepository;

    @Autowired
    private IQuestionsService questionsService;

    private final IQuizDocToQuizDataMapper quizDocToQuizDataMapper = new QuizDocToQuizDataMapper();


    @Override
    public List<QuizDoc> findAllQuizzes() {
        return quizzesRepository.findAll().stream().map(quizDocToQuizDataMapper::toQuizDoc).toList();
    }

    @Override
    public QuizDoc createQuiz(QuizDoc quizDoc) {
        return quizDocToQuizDataMapper.toQuizDoc(
                quizzesRepository.create(quizDocToQuizDataMapper.toQuizData(quizDoc))
        );
    }

    @Override
    public void deleteQuiz(Integer quizId) throws InvalidKeyException {
        quizzesRepository.delete(quizId);
        questionsService.deleteForQuiz(quizId);

    }

    @Override
    public QuizDoc findQuiz(Integer quizId) {
        return quizDocToQuizDataMapper.toQuizDoc(quizzesRepository.find(quizId));
    }

    @Override
    public QuizDoc updateQuiz(Integer quizId, QuizDoc quizDoc) throws InvalidKeyException {
        return quizDocToQuizDataMapper.toQuizDoc(
                quizzesRepository.update(quizId, quizDocToQuizDataMapper.toQuizData(quizDoc))
        );
    }
}
