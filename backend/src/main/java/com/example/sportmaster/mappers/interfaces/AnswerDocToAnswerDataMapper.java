package com.example.sportmaster.mappers.interfaces;

import com.example.sportmaster.models.answers.AnswerData;
import com.example.sportmaster.models.answers.AnswerDoc;

public interface AnswerDocToAnswerDataMapper {
    public AnswerDoc toAnswerDoc(AnswerData data);
    public AnswerData toAnswerData(AnswerDoc doc);
}
