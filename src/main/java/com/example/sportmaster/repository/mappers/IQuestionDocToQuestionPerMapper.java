package com.example.sportmaster.repository.mappers;

import com.example.sportmaster.repository.models.QuestionData;
import com.example.sportmaster.service.models.QuestionDoc;

public interface IQuestionDocToQuestionPerMapper {
    public QuestionData toQuestionPer(QuestionDoc quizDoc);

    public QuestionDoc toQuestionDoc(QuestionData quizPer);
}
