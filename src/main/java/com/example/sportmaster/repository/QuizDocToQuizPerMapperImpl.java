package com.example.sportmaster.repository;

import com.example.sportmaster.service.QuizDoc;

public class QuizDocToQuizPerMapperImpl implements IQuizDocToQuizPerMapper {
    public QuizPer toQuizPer(QuizDoc quizDoc) {
        QuizPer quizPer;
        quizPer = new QuizPer();

        quizPer.setId(quizDoc.getId());
        quizPer.setDescription(quizDoc.getDescription());
        quizPer.setTitle(quizPer.getTitle());

        return quizPer;

    }
    public QuizDoc toQuizDoc(QuizPer quizPer) {
        QuizDoc quizDoc;
        quizDoc = new QuizDoc();

        quizDoc.setId(quizPer.getId());
        quizDoc.setDescription(quizPer.getDescription());
        quizDoc.setTitle(quizPer.getTitle());

        return quizDoc;


    }
}
