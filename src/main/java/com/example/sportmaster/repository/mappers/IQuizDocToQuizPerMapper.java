package com.example.sportmaster.repository.mappers;

import com.example.sportmaster.repository.models.QuizData;
import com.example.sportmaster.service.models.QuizDoc;

public interface IQuizDocToQuizPerMapper {
    public QuizData toQuizPer(QuizDoc quizDoc);
    public QuizDoc toQuizDoc(QuizData quizData);
}
