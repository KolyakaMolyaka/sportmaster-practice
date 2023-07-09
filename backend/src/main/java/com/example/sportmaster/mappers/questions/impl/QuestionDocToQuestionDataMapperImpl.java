package com.example.sportmaster.mappers.questions.impl;

import com.example.sportmaster.mappers.questions.QuestionDocToQuestionDataMapper;
import com.example.sportmaster.models.questions.QuestionData;
import com.example.sportmaster.models.questions.QuestionDoc;

public class QuestionDocToQuestionDataMapperImpl implements QuestionDocToQuestionDataMapper {
    @Override
    public QuestionDoc toQuestionDoc(QuestionData data) {
        if (data == null) return null;

        QuestionDoc doc = new QuestionDoc();
        doc.setId(data.getId());
        doc.setText(data.getText());

        return doc;
    }

    @Override
    public QuestionData toQuestionData(QuestionDoc doc) {
        if (doc == null) return null;

        QuestionData data = new QuestionData();
        data.setId(doc.getId());
        data.setText(doc.getText());

        return data;
    }
}
