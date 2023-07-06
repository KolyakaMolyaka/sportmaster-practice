package com.example.sportmaster;

import com.example.sportmaster.openapi.model.AnswerDTO;

public interface IAnswerDTOToAnswerDocMapper {
    public AnswerDTO toAnswerDTO(AnswerDoc answerDoc);

    public AnswerDoc toAnswerDoc(AnswerDTO answerDTO);
}
