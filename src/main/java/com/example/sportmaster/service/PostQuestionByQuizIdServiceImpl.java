package com.example.sportmaster.service;

import com.example.sportmaster.openapi.model.QuestionDTO;

public class PostQuestionByQuizIdServiceImpl implements IPostQuestionByQuizIdService {
    public QuestionDoc quizzesQuizIdQuestionsPost(Integer quizId, QuestionDTO question) {
        QuizDoc quiz = new QuizDoc();
        quiz.id(quizId);
        question.setId((int) (Math.random() * 15)); // случайное число от 0 до 15

        QuestionDoc newQuestion = new QuestionDoc();
        newQuestion.setId(question.getId());

        quiz.addQuestionsItem(newQuestion);

        return newQuestion;
    }
}
