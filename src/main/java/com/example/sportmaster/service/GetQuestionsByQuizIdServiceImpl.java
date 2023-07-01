package com.example.sportmaster.service;

import java.util.ArrayList;
import java.util.List;

public class GetQuestionsByQuizIdServiceImpl implements IGetQuestionsByQuizIdService {
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
}
