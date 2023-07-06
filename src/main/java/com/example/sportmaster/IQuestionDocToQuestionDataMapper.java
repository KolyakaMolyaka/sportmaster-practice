package com.example.sportmaster;

public interface IQuestionDocToQuestionDataMapper {
    public QuestionDoc toQuestionDoc(QuestionData data);
    public QuestionData toQuestionData(QuestionDoc doc);
}
