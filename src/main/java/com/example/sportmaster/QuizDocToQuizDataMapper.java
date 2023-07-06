package com.example.sportmaster;

public class QuizDocToQuizDataMapper implements  IQuizDocToQuizDataMapper {

    @Override
    public QuizDoc toQuizDoc(QuizData data) {
        if (data == null) return null;

        QuizDoc doc = new QuizDoc();
        doc.setId(data.getId());
        doc.setTitle(data.getTitle());
        doc.setDescription(data.getDescription());
        doc.setCategory(data.getCategory());
        doc.setDifficulty(data.getDifficulty());
        doc.setCreatedAt(data.getCreatedAt());

        return doc;
    }

    @Override
    public QuizData toQuizData(QuizDoc doc) {
        if (doc == null) return null;

        QuizData data = new QuizData();
        data.setId(doc.getId());
        data.setTitle(doc.getTitle());
        data.setDescription(doc.getDescription());
        data.setCategory(doc.getCategory());
        data.setDifficulty(doc.getDifficulty());
        data.setCreatedAt(doc.getCreatedAt());

        return data;
    }
}
