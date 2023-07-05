package com.example.sportmaster;

import com.example.sportmaster.service.models.QuestionDoc;
import com.example.sportmaster.service.models.QuizDoc;

import java.util.List;
public interface IQuizzesApiService {
    public QuizDoc getQuiz(Integer quizId);

    public boolean deleteQuiz(Integer quizId);

    public QuizDoc updateQuiz(Integer quizId, QuizDoc quiz);

    public List<QuizDoc> findAllQuizzes();

    public QuizDoc createQuiz(QuizDoc quiz);

    public List<QuestionDoc> findAllQuestionsFor(Integer quizId);

    public QuestionDoc createQuestionForQuiz(Integer quizId, QuestionDoc question);

    public boolean deleteQuestionFromQuiz(Integer quizId, Integer questionId);

}
