package com.example.sportmaster.repository;

import com.example.sportmaster.service.QuizDoc;

public interface IQuizDocToQuizPerMapper {
    public QuizPer toQuizPer(QuizDoc quizDoc);
    public QuizDoc toQuizDoc(QuizPer quizPer);
}
