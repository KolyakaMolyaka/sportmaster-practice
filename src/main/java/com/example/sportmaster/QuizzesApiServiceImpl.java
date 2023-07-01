package com.example.sportmaster;

import com.example.sportmaster.openapi.model.QuestionDTO;
import com.example.sportmaster.openapi.model.QuizDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class QuizzesApiServiceImpl implements IQuizzesApiService {
    /* Пример реализации собственного метода */
    public QuizDoc quizzesQuizIdGet(Integer quizId) {
        QuizDoc quiz = new QuizDoc();
        if (quizId == 1) {
            quiz.description("This is the first quiz");
        } else {
            quiz.description("This is not the first quiz :(");
        }
        return quiz;
    }

    public boolean quizzesQuizIdDelete(Integer quizId) {
        // deleting quiz
        boolean deleteOperation = false;
        if (1 == quizId) deleteOperation = true;
        return deleteOperation;
    }
    public QuizDoc quizzesQuizIdPut(Integer quizId, QuizDTO quiz) {
        // updating quiz, returning QuizDoc ..
        QuizDoc quizdoc = new QuizDoc();
        quizdoc.description("updated description");

        return quizdoc;
    }

    public List<QuizDoc> quizzesGet() {
        List<QuizDoc> stubQuizzes = new ArrayList<>();

        QuizDoc stubQuiz1 = new QuizDoc();
        stubQuiz1.title("Stub title - quiz 1");
        stubQuiz1.description("Stub description - quiz1");

        QuizDoc stubQuiz2 = new QuizDoc();
        stubQuiz2.title("Stub title - quiz 2");
        stubQuiz2.description("Stub description - quiz2");

        stubQuizzes.add(stubQuiz1);
        stubQuizzes.add(stubQuiz2);

        return stubQuizzes;
    }

    public QuizDoc quizzesPost(QuizDTO quiz) {
        // добавление QuizDTO, получение QuizDoc
        QuizDoc quizDoc = new QuizDoc();
        // изменение полей из QuizDTO
        quizDoc.title(quiz.getTitle().toUpperCase());
        quizDoc.description(quiz.getDescription().toUpperCase());

        return quizDoc;
    }

    public List<QuestionDoc> quizzesQuizIdQuestionsGet(Integer quizId) {
        ArrayList<QuestionDoc> questions = new ArrayList<>();

        QuestionDoc q1 = new QuestionDoc();
        QuestionDoc q2 = new QuestionDoc();

        q1.text("Question 1");
        q2.text("Question 2");

        questions.add(q1);
        questions.add(q2);

        return questions;
    }

    public QuestionDoc quizzesQuizIdQuestionsPost(Integer quizId, QuestionDTO question) {
        QuizDoc quiz = new QuizDoc();
        quiz.id(quizId);
        question.setId((int) (Math.random() * 15)); // случайное число от 0 до 15

        QuestionDoc newQuestion = new QuestionDoc();
        newQuestion.setId(question.getId());

        quiz.addQuestionsItem(newQuestion);

        return newQuestion;
    }

    public boolean quizzesQuizIdQuestionsQuestionIdDelete(Integer quizId, Integer questionId) {

        QuizDoc quiz = new QuizDoc();
        quiz.setId(quizId);

        QuestionDoc question = new QuestionDoc();
        question.setId(1);

        QuestionDoc question2 = new QuestionDoc();
        question2.setId(2);


        quiz.addQuestionsItem(question);
        quiz.addQuestionsItem(question2);

        // имитация удаления вопроса с ID=1
        // (вопрос с ID=2 продолжает существовать), т.е. bad request будет всегда, кроме запрсоа с ID=1

        List<QuestionDTO> questions = quiz.getQuestions();
        questions.remove(question);

        boolean deleteOperation = true;
        for (QuestionDTO q: questions) {
            if (Objects.equals(q.getId(), questionId)) {
                deleteOperation = false;
                break;
            }
        }
        return deleteOperation;
    }

}
