package com.example.sportmaster.repositories.answers;

import com.example.sportmaster.models.AnswerData;

import java.security.InvalidKeyException;
import java.util.List;

public interface AnswersRepository {
    AnswerData create(Integer questionId, AnswerData answerData);

    public List<AnswerData> findAll(Integer questionId);

    AnswerData find(Integer answerId);

    AnswerData update(Integer answerId, AnswerData answerData) throws InvalidKeyException;

    void delete(Integer answerId);

    void deleteForQuestion(Integer questionId);
}
