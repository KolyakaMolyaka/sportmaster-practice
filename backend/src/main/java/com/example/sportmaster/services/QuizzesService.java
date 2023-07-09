package com.example.sportmaster.services;

import com.example.sportmaster.repositories.interfaces.QuizzesRepository;
import com.example.sportmaster.models.QuizDoc;
import com.example.sportmaster.mappers.interfaces.QuizDocToQuizDataMapper;
import com.example.sportmaster.services.interfaces.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidKeyException;
import java.util.List;

@Service
public class QuizzesService implements com.example.sportmaster.services.interfaces.QuizzesService {
    @Autowired
    private QuizzesRepository quizzesRepository;

    @Autowired
    private QuestionsService questionsService;

    private final QuizDocToQuizDataMapper quizDocToQuizDataMapper = new com.example.sportmaster.mappers.QuizDocToQuizDataMapper();


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
