package com.example.sportmaster.service.mappers;

import com.example.sportmaster.openapi.model.QuestionDTO;
import com.example.sportmaster.service.models.QuestionDoc;

public interface IQuestionDtoToQuestionDocMapper {
    public QuestionDTO toQuestionDto(QuestionDoc questionDoc);
    public QuestionDoc toQuestionDoc(QuestionDTO questionDto);
}
