package com.example.sportmaster.repository;

import com.example.sportmaster.repository.models.QuestionData;
import com.example.sportmaster.repository.models.QuizData;

import java.util.ArrayList;
import java.util.List;

public class QuizzesRepositoryImpl implements IQuizzesRepository {
    public QuizData getQuiz(Integer quizId) {
        QuizData quiz = new QuizData();
        if (quizId == 1) {
            quiz.setDescription("This is the first quiz");
        } else {
            quiz.setDescription("This is not the first quiz :(");
        }
        return quiz;

    }

    public boolean deleteQuiz(Integer quizId) {
        // deleting quiz
        boolean deleteOperation = false;
        if (1 == quizId) deleteOperation = true;
        return deleteOperation;
    }

    public QuizData updateQuiz(Integer quizId, QuizData quiz) {
        quiz.setDescription("updated description");
        return quiz;
    }

    public List<QuizData> getQuizzes() {
        List<QuizData> stubQuizzes = new ArrayList<>();

        QuizData stubQuiz1 = new QuizData();
        stubQuiz1.setTitle("Stub title - quiz 1");
        stubQuiz1.setDescription("Stub description - quiz1");

        QuizData stubQuiz2 = new QuizData();
        stubQuiz2.setTitle("Stub title - quiz 2");
        stubQuiz2.setDescription("Stub description - quiz2");

        stubQuizzes.add(stubQuiz1);
        stubQuizzes.add(stubQuiz2);
        return stubQuizzes;
    }

    public QuizData createQuiz(QuizData quiz) {
        quiz.setTitle(quiz.getTitle().toUpperCase());
        quiz.setDescription(quiz.getDescription().toUpperCase());
        return quiz;
    }

    public List<QuestionData> getQuestions(Integer quizId) {
        ArrayList<QuestionData> questions = new ArrayList<>();

        QuestionData q1 = new QuestionData();
        QuestionData q2 = new QuestionData();

        q1.setText("Question 1");
        q2.setText("Question 2");

        questions.add(q1);
        questions.add(q2);

        return questions;

    }

    public QuestionData createQuestion(Integer quizId, QuestionData question) {
        QuestionData newQuestion = new QuestionData();
        newQuestion.setId((int) (Math.random() * 15));
        return newQuestion;
    }

    public boolean deleteQuestion(Integer quizId, Integer questionId) {
        return questionId % 2 == 0; // четное число -> удаление успешно,  нечетное - нет
    }
}
