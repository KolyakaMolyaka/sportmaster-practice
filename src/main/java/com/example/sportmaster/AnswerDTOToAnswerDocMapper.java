package com.example.sportmaster;

import com.example.sportmaster.openapi.model.AnswerDTO;

public class AnswerDTOToAnswerDocMapper implements IAnswerDTOToAnswerDocMapper {
    @Override
    public AnswerDTO toAnswerDTO(AnswerDoc doc) {
        if (doc == null) return null;

        AnswerDTO dto = new AnswerDTO();
        dto.setId(doc.getId());
        dto.setText(doc.getText());
        dto.setIsCorrect(doc.getIsCorrect());

        return dto;
    }

    @Override
    public AnswerDoc toAnswerDoc(AnswerDTO dto) {
        if (dto == null) return null;
        AnswerDoc doc = new AnswerDoc();

        doc.setId(dto.getId());
        doc.setText(dto.getText());
        doc.setIsCorrect(dto.getIsCorrect());

        return doc;
    }
}
