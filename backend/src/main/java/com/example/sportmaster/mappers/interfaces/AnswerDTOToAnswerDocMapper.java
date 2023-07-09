package com.example.sportmaster.mappers.interfaces;

import com.example.sportmaster.models.AnswerDoc;
import com.example.sportmaster.openapi.model.AnswerDTO;

public interface AnswerDTOToAnswerDocMapper {
    public AnswerDTO toAnswerDTO(AnswerDoc answerDoc);

    public AnswerDoc toAnswerDoc(AnswerDTO answerDTO);
}
