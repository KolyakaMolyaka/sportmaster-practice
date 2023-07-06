package com.example.sportmaster;

import com.example.sportmaster.openapi.model.QuizDTO;

public class QuizDTOToQuizDocMapper implements IQuizDTOToQuizDocMapper {
    @Override
    public QuizDoc toQuizDTO(QuizDoc doc) {
        if (doc == null) return null;
        return (QuizDoc) doc;
    }

    @Override
    public QuizDoc toQuizDoc(QuizDTO dto) {
        if (dto == null) return null;
        QuizDoc doc = new QuizDoc();
        doc.setId(dto.getId());
        doc.setTitle(dto.getTitle());
        doc.setDescription(dto.getDescription());
        doc.setDifficulty(dto.getDifficulty());
        doc.setCategory(dto.getCategory());
        doc.setCreatedAt(dto.getCreatedAt());
        return doc;
    }

}
