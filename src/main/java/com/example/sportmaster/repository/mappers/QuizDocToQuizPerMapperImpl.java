package com.example.sportmaster.repository.mappers;

import com.example.sportmaster.repository.models.QuizData;
import com.example.sportmaster.service.models.QuizDoc;

public class QuizDocToQuizPerMapperImpl implements IQuizDocToQuizPerMapper {
    public QuizData toQuizPer(QuizDoc quizDoc) {
        QuizData quizData;
        quizData = new QuizData();

        quizData.setId(quizDoc.getId());
        quizData.setDescription(quizDoc.getDescription());
        quizData.setTitle(quizDoc.getTitle());

        return quizData;

    }
    public QuizDoc toQuizDoc(QuizData quizData) {
        QuizDoc quizDoc;
        quizDoc = new QuizDoc();

        quizDoc.setId(quizData.getId());
        quizDoc.setDescription(quizData.getDescription());
        quizDoc.setTitle(quizData.getTitle());

        return quizDoc;


    }
}
