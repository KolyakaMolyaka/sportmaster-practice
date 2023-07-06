package com.example.sportmaster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidKeyException;
import java.util.List;

@Service
public class QuizzesService implements IQuizzesService {
    @Autowired
    private IQuizzesRepository quizzesRepository;

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
