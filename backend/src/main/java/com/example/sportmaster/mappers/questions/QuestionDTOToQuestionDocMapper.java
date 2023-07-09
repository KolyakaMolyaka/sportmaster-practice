package com.example.sportmaster.mappers.questions;

import com.example.sportmaster.models.questions.QuestionDoc;
import com.example.sportmaster.openapi.model.QuestionDTO;

public interface QuestionDTOToQuestionDocMapper {
    public QuestionDTO toQuestionDTO(QuestionDoc doc);
    public QuestionDoc toQuestionDoc(QuestionDTO dto);
}
