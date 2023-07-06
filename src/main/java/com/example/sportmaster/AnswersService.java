package com.example.sportmaster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidKeyException;

@Service
public class AnswersService implements IAnswersService {
    @Autowired
    private IQuestionsRepository questionsRepository;

    @Autowired
    private IAnswersRepository answersRepository;

    private IAnswerDocToAnswerDataMapper answerDocToAnswerDataMapper = new AnswerDocToAnswerDataMapper();
    @Override
    public AnswerDoc createAnswer(Integer questionId, AnswerDoc answerDoc) throws InvalidKeyException {
        if (questionsRepository.find(questionId) == null) throw new InvalidKeyException("Вопроса с заданным ID не существует");
        return answerDocToAnswerDataMapper.toAnswerDoc(
                answersRepository.create(questionId, answerDocToAnswerDataMapper.toAnswerData(answerDoc))
        );
    }
}
