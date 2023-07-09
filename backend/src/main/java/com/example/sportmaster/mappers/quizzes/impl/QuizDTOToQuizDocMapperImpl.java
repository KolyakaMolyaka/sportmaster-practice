package com.example.sportmaster.mappers.quizzes.impl;

import com.example.sportmaster.mappers.quizzes.QuizDTOToQuizDocMapper;
import com.example.sportmaster.models.quizzes.QuizDoc;
import com.example.sportmaster.openapi.model.QuizDTO;

public class QuizDTOToQuizDocMapperImpl implements QuizDTOToQuizDocMapper {
    @Override
    public QuizDTO toQuizDTO(QuizDoc doc) {
        if (doc == null) return null;
        QuizDTO dto = new QuizDTO();
        dto.setId(doc.getId());
        dto.setTitle(doc.getTitle());
        dto.setDescription(doc.getDescription());
        dto.setDifficulty(doc.getDifficulty());
        dto.setCategory(doc.getCategory());
        dto.setCreatedAt(doc.getCreatedAt());
        return dto;
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
        return doc;
    }

}
