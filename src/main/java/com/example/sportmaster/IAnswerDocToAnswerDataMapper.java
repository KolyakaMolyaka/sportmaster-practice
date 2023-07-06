package com.example.sportmaster;

public interface IAnswerDocToAnswerDataMapper {
    public AnswerDoc toAnswerDoc(AnswerData data);
    public AnswerData toAnswerData(AnswerDoc doc);
}
