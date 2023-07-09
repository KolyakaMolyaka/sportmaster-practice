package com.example.sportmaster.mappers.interfaces;

import com.example.sportmaster.models.QuizDoc;
import com.example.sportmaster.openapi.model.QuizDTO;

public interface IQuizDTOToQuizDocMapper {
    public QuizDTO toQuizDTO(QuizDoc doc);
    public QuizDoc toQuizDoc(QuizDTO dto);
}
