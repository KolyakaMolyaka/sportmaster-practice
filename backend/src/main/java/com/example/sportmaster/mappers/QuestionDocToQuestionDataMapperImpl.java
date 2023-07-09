package com.example.sportmaster.mappers;

import com.example.sportmaster.models.QuestionData;
import com.example.sportmaster.models.QuestionDoc;

public class QuestionDocToQuestionDataMapperImpl implements com.example.sportmaster.mappers.interfaces.QuestionDocToQuestionDataMapper {
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
