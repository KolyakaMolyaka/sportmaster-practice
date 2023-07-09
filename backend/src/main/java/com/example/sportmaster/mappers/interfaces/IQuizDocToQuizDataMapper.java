package com.example.sportmaster.mappers.interfaces;

import com.example.sportmaster.models.QuizData;
import com.example.sportmaster.models.QuizDoc;

public interface IQuizDocToQuizDataMapper {
    public QuizDoc toQuizDoc(QuizData data);
    public QuizData toQuizData(QuizDoc doc);
}
