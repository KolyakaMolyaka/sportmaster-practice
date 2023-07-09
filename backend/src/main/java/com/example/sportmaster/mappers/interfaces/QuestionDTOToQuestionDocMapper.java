package com.example.sportmaster.mappers.interfaces;

import com.example.sportmaster.models.QuestionDoc;
import com.example.sportmaster.openapi.model.QuestionDTO;

public interface QuestionDTOToQuestionDocMapper {
    public QuestionDTO toQuestionDTO(QuestionDoc doc);
    public QuestionDoc toQuestionDoc(QuestionDTO dto);
}
