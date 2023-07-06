package com.example.sportmaster.mappers.interfaces;

import com.example.sportmaster.models.AnswerData;
import com.example.sportmaster.models.AnswerDoc;

public interface IAnswerDocToAnswerDataMapper {
    public AnswerDoc toAnswerDoc(AnswerData data);
    public AnswerData toAnswerData(AnswerDoc doc);
}
