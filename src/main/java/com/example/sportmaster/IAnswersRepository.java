package com.example.sportmaster;

import java.util.List;

public interface IAnswersRepository {
    AnswerData create(Integer questionId, AnswerData answerData);

    public List<AnswerData> findAll(Integer questionId);
}
