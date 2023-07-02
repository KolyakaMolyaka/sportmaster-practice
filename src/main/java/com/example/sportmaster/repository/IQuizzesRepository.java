package com.example.sportmaster.repository;

import com.example.sportmaster.repository.models.QuizPer;
import com.example.sportmaster.service.models.QuizDoc;

import java.util.List;

public interface IQuizzesRepository {
    public QuizPer quizzesQuizIdGet(Integer quizId);
    public boolean quizzesQuizIdDelete(Integer quizId);
    public QuizPer quizzesQuizIdPut(Integer quizId, QuizPer quiz);
    public List<QuizPer> quizzesGet();
}
