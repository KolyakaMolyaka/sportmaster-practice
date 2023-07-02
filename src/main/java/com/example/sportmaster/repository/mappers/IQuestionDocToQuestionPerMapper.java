package com.example.sportmaster.repository.mappers;

import com.example.sportmaster.repository.models.QuestionPer;
import com.example.sportmaster.service.models.QuestionDoc;

public interface IQuestionDocToQuestionPerMapper {
    public QuestionPer toQuestionPer(QuestionDoc quizDoc);

    public QuestionDoc toQuestionDoc(QuestionPer quizPer);
}
