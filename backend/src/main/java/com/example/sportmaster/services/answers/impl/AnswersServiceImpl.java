package com.example.sportmaster.services.answers.impl;

import com.example.sportmaster.mappers.AnswerDocToAnswerDataMapperImpl;
import com.example.sportmaster.models.AnswerDoc;
import com.example.sportmaster.repositories.interfaces.AnswersRepository;
import com.example.sportmaster.repositories.interfaces.QuestionsRepository;
import com.example.sportmaster.mappers.interfaces.AnswerDocToAnswerDataMapper;
import com.example.sportmaster.services.answers.AnswersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidKeyException;
import java.util.List;

@Service
public class AnswersServiceImpl implements AnswersService {
    @Autowired
    private QuestionsRepository questionsRepository;

    @Autowired
    private AnswersRepository answersRepository;

    private AnswerDocToAnswerDataMapper answerDocToAnswerDataMapper = new AnswerDocToAnswerDataMapperImpl();
    @Override
    public AnswerDoc createAnswer(Integer questionId, AnswerDoc answerDoc) throws InvalidKeyException {
        if (questionsRepository.find(questionId) == null) throw new InvalidKeyException("Вопроса с заданным ID не существует");
        return answerDocToAnswerDataMapper.toAnswerDoc(
                answersRepository.create(questionId, answerDocToAnswerDataMapper.toAnswerData(answerDoc))
        );
    }

    @Override
    public List<AnswerDoc> findAllAnswers(Integer questionId) throws InvalidKeyException {
        if (questionsRepository.find(questionId) == null) throw new InvalidKeyException("Вопроса с заданным ID не существует");
        return answersRepository.findAll(questionId)
                .stream()
                .map(answerDocToAnswerDataMapper::toAnswerDoc)
                .toList();
    }

    @Override
    public AnswerDoc updateAnswer(Integer questionId, Integer answerId, AnswerDoc answerDoc) throws InvalidKeyException {
        if (questionsRepository.find(questionId) == null) throw new InvalidKeyException("Вопроса с заданным ID не существует");

        return answerDocToAnswerDataMapper.toAnswerDoc(
                answersRepository.update(answerId, answerDocToAnswerDataMapper.toAnswerData(answerDoc))
        );
    }

    @Override
    public AnswerDoc getAnswer(Integer questionId, Integer answerId) {
        if (questionsRepository.find(questionId) == null) return null;
        return answerDocToAnswerDataMapper.toAnswerDoc(answersRepository.find(answerId));
    }

    @Override
    public void deleteAnswer(Integer answerId) throws InvalidKeyException {
        if (answersRepository.find(answerId) == null) throw new InvalidKeyException("Вопроса с указанным ID не существует");
        answersRepository.delete(answerId);

    }

    @Override
    public void deleteAnswersForQuestion(Integer questionId) {
        answersRepository.deleteForQuestion(questionId);

    }
}
