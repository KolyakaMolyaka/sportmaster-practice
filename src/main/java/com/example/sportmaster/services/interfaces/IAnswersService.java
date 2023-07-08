package com.example.sportmaster.services.interfaces;

import com.example.sportmaster.models.AnswerDoc;

import java.security.InvalidKeyException;
import java.util.List;

public interface IAnswersService {
    public AnswerDoc createAnswer(Integer questionId, AnswerDoc answerDoc) throws InvalidKeyException;

    public List<AnswerDoc> findAllAnswers(Integer questionId) throws InvalidKeyException;

    AnswerDoc updateAnswer(Integer questionId, Integer answerId, AnswerDoc answerDoc) throws InvalidKeyException;

    AnswerDoc getAnswer(Integer questionId, Integer answerId);

    void deleteAnswer(Integer answerId) throws InvalidKeyException;
}
