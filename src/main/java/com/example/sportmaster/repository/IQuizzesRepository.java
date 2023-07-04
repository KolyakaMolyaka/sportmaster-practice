package com.example.sportmaster.repository;

import com.example.sportmaster.repository.models.QuestionPer;
import com.example.sportmaster.repository.models.QuizPer;

import java.util.List;

public interface IQuizzesRepository {
    public QuizPer getQuiz(Integer quizId);

    public boolean deleteQuiz(Integer quizId);

    public QuizPer updateQuiz(Integer quizId, QuizPer quiz);

    public List<QuizPer> getQuizzes();

    public QuizPer createQuiz(QuizPer quiz);

    public List<QuestionPer> getQuestions(Integer quizId);
    public QuestionPer createQuestion(Integer quizId, QuestionPer question);
    public boolean deleteQuestion(Integer quizId, Integer questionId);
}
