package com.example.sportmaster;

public class AnswerDocToAnswerDataMapper implements IAnswerDocToAnswerDataMapper {
    @Override
    public AnswerDoc toAnswerDoc(AnswerData data) {
        if (data == null) return null;

        AnswerDoc doc = new AnswerDoc();
        doc.setId(data.getId());
        doc.setText(data.getText());
        doc.setIsCorrect(data.getIsCorrect());

        return doc;
    }

    @Override
    public AnswerData toAnswerData(AnswerDoc doc) {
        if (doc == null) return null;

        AnswerData data = new AnswerData();
        data.setId(doc.getId());
        data.setText(doc.getText());
        data.setIsCorrect(doc.getIsCorrect());

        return data;
    }
}
