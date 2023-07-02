package com.example.sportmaster.repository.mappers;

import com.example.sportmaster.repository.models.QuizPer;
import com.example.sportmaster.service.models.QuizDoc;

public interface IQuizDocToQuizPerMapper {
    public QuizPer toQuizPer(QuizDoc quizDoc);
    public QuizDoc toQuizDoc(QuizPer quizPer);
}
