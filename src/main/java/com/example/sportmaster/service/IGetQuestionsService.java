package com.example.sportmaster.service;

import com.example.sportmaster.service.models.QuestionDoc;

import java.util.List;

public interface IGetQuestionsService {
    public List<QuestionDoc> getQuestionsFor(Integer quizId);
}
