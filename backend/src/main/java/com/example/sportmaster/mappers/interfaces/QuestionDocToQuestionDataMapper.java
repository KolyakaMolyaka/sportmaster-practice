package com.example.sportmaster.mappers.interfaces;

import com.example.sportmaster.models.QuestionData;
import com.example.sportmaster.models.QuestionDoc;

public interface QuestionDocToQuestionDataMapper {
    public QuestionDoc toQuestionDoc(QuestionData data);
    public QuestionData toQuestionData(QuestionDoc doc);
}
