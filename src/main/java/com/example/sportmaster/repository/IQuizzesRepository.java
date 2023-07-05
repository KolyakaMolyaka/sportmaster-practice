package com.example.sportmaster.repository;

import com.example.sportmaster.repository.models.QuestionData;
import com.example.sportmaster.repository.models.QuizData;

import java.util.List;

public interface IQuizzesRepository {
    public QuizData getQuiz(Integer quizId);

    public boolean deleteQuiz(Integer quizId);

    public QuizData updateQuiz(Integer quizId, QuizData quiz);

    public List<QuizData> getQuizzes();

    public QuizData createQuiz(QuizData quiz);

    public List<QuestionData> getQuestions(Integer quizId);
    public QuestionData createQuestion(Integer quizId, QuestionData question);
    public boolean deleteQuestion(Integer quizId, Integer questionId);
}
