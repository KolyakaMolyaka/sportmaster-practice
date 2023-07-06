package com.example.sportmaster;

import com.example.sportmaster.openapi.model.QuestionDTO;

public interface IQuestionDTOToQuestionDocMapper {
    public QuestionDTO toQuestionDTO(QuestionDoc doc);
    public QuestionDoc toQuestionDoc(QuestionDTO dto);
}
