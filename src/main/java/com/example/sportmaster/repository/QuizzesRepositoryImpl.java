package com.example.sportmaster.repository;

import com.example.sportmaster.repository.models.QuestionPer;
import com.example.sportmaster.repository.models.QuizPer;
import com.example.sportmaster.service.models.QuestionDoc;
import com.example.sportmaster.service.models.QuizDoc;

import java.util.ArrayList;
import java.util.List;

public class QuizzesRepositoryImpl implements IQuizzesRepository {
    public QuizPer getQuiz(Integer quizId) {
        QuizPer quiz = new QuizPer();
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

    public QuizPer updateQuiz(Integer quizId, QuizPer quiz) {
        quiz.setDescription("updated description");
        return quiz;
    }

    public List<QuizPer> getQuizzes() {
        List<QuizPer> stubQuizzes = new ArrayList<>();

        QuizPer stubQuiz1 = new QuizPer();
        stubQuiz1.setTitle("Stub title - quiz 1");
        stubQuiz1.setDescription("Stub description - quiz1");

        QuizPer stubQuiz2 = new QuizPer();
        stubQuiz2.setTitle("Stub title - quiz 2");
        stubQuiz2.setDescription("Stub description - quiz2");

        stubQuizzes.add(stubQuiz1);
        stubQuizzes.add(stubQuiz2);
        return stubQuizzes;
    }

    public QuizPer createQuiz(QuizPer quiz) {
        quiz.setTitle(quiz.getTitle().toUpperCase());
        quiz.setDescription(quiz.getDescription().toUpperCase());
        return quiz;
    }

    public List<QuestionPer> getQuestions(Integer quizId) {
        ArrayList<QuestionPer> questions = new ArrayList<>();

        QuestionPer q1 = new QuestionPer();
        QuestionPer q2 = new QuestionPer();

        q1.setText("Question 1");
        q2.setText("Question 2");

        questions.add(q1);
        questions.add(q2);

        return questions;

    }

    public QuestionPer createQuestion(Integer quizId, QuestionPer question) {
        QuestionPer newQuestion = new QuestionPer();
        newQuestion.setId((int) (Math.random() * 15));
        return newQuestion;
    }

    public boolean deleteQuestion(Integer quizId, Integer questionId) {
        return questionId % 2 == 0; // четное число -> удаление успешно,  нечетное - нет
    }
}
