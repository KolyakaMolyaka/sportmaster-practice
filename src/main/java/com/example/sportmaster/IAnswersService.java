package com.example.sportmaster;

import org.springframework.stereotype.Service;

import java.security.InvalidKeyException;

public interface IAnswersService {
    AnswerDoc createAnswer(Integer questionId, AnswerDoc answerDoc) throws InvalidKeyException;
}
