package com.example.sportmaster.service;


import com.example.sportmaster.service.models.QuestionDoc;

public class PostQuestionByQuizIdServiceImpl implements IPostQuestionByQuizIdService {

    public QuestionDoc quizzesQuizIdQuestionsPost(Integer quizId, QuestionDoc question) {
        QuestionDoc newQuestion = new QuestionDoc();
        newQuestion.setId(question.getId());
        return newQuestion;
    }
}
