package com.example.sportmaster.service;


public class PostQuestionByQuizIdServiceImpl implements IPostQuestionByQuizIdService {

    public QuestionDoc quizzesQuizIdQuestionsPost(Integer quizId, QuestionDoc question) {
        QuestionDoc newQuestion = new QuestionDoc();
        newQuestion.setId(question.getId());
        return newQuestion;
    }
}
