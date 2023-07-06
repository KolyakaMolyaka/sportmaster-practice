package com.example.sportmaster;

public interface IQuizDocToQuizDataMapper {
    public QuizDoc toQuizDoc(QuizData data);
    public QuizData toQuizData(QuizDoc doc);
}
