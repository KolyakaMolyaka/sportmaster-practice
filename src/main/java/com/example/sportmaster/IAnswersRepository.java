package com.example.sportmaster;

public interface IAnswersRepository {
    AnswerData create(Integer questionId, AnswerData answerData);
}
