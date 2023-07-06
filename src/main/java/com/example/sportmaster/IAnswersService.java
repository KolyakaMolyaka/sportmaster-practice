package com.example.sportmaster;

import com.example.sportmaster.openapi.model.AnswerDTO;
import org.springframework.stereotype.Service;

import java.security.InvalidKeyException;
import java.util.List;

public interface IAnswersService {
    public AnswerDoc createAnswer(Integer questionId, AnswerDoc answerDoc) throws InvalidKeyException;

    public List<AnswerDoc> findAllAnswers(Integer questionId) throws InvalidKeyException;

    AnswerDoc updateAnswer(Integer questionId, Integer answerId, AnswerDoc answerDoc) throws InvalidKeyException;
}
