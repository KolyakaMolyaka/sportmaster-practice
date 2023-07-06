package com.example.sportmaster;

import java.security.InvalidKeyException;
import java.util.List;

public interface IAnswersRepository {
    AnswerData create(Integer questionId, AnswerData answerData);

    public List<AnswerData> findAll(Integer questionId);

    AnswerData find(Integer answerId);

    AnswerData update(Integer answerId, AnswerData answerData) throws InvalidKeyException;
}
