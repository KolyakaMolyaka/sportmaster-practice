package com.example.sportmaster.mappers.interfaces;

import com.example.sportmaster.models.questions.QuestionData;
import com.example.sportmaster.models.questions.QuestionDoc;

public interface QuestionDocToQuestionDataMapper {
    public QuestionDoc toQuestionDoc(QuestionData data);
    public QuestionData toQuestionData(QuestionDoc doc);
}
