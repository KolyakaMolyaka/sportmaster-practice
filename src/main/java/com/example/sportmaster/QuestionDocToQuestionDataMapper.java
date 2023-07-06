package com.example.sportmaster;

public class QuestionDocToQuestionDataMapper implements IQuestionDocToQuestionDataMapper{
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
