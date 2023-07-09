package com.example.sportmaster.services.quizzes.impl;

import com.example.sportmaster.mappers.quizzes.impl.QuizDocToQuizDataMapperImpl;
import com.example.sportmaster.repositories.quizzes.QuizzesRepository;
import com.example.sportmaster.models.quizzes.QuizDoc;
import com.example.sportmaster.mappers.quizzes.QuizDocToQuizDataMapper;
import com.example.sportmaster.services.questions.QuestionsService;
import com.example.sportmaster.services.quizzes.QuizzesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidKeyException;
import java.util.List;

@Service
public class QuizzesServiceImpl implements QuizzesService {
    @Autowired
    private QuizzesRepository quizzesRepository;

    @Autowired
    private QuestionsService questionsService;

    private final QuizDocToQuizDataMapper quizDocToQuizDataMapper = new QuizDocToQuizDataMapperImpl();


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
