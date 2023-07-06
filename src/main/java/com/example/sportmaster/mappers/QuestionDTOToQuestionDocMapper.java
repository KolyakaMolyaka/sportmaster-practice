package com.example.sportmaster.mappers;

import com.example.sportmaster.models.QuestionDoc;
import com.example.sportmaster.mappers.interfaces.IQuestionDTOToQuestionDocMapper;
import com.example.sportmaster.openapi.model.QuestionDTO;

public class QuestionDTOToQuestionDocMapper implements IQuestionDTOToQuestionDocMapper {

    @Override
    public QuestionDTO toQuestionDTO(QuestionDoc doc) {
        if (doc == null) return null;
        QuestionDTO dto = new QuestionDTO();
        dto.setId(doc.getId());
        dto.setText(doc.getText());
        return dto;
    }

    @Override
    public QuestionDoc toQuestionDoc(QuestionDTO dto) {
        if (dto == null) return null;
        QuestionDoc doc = new QuestionDoc();
        doc.setId(dto.getId());
        doc.setText(dto.getText());

        return doc;
    }
}
