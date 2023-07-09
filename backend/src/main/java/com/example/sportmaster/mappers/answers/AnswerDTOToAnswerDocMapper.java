package com.example.sportmaster.mappers.answers;

import com.example.sportmaster.models.answers.AnswerDoc;
import com.example.sportmaster.openapi.model.AnswerDTO;

public interface AnswerDTOToAnswerDocMapper {
    public AnswerDTO toAnswerDTO(AnswerDoc answerDoc);

    public AnswerDoc toAnswerDoc(AnswerDTO answerDTO);
}
