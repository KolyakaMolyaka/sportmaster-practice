package com.example.sportmaster;

import com.example.sportmaster.openapi.model.QuizDTO;

public interface IQuizDTOToQuizDocMapper {
    public QuizDTO toQuizDTO(QuizDoc doc);
    public QuizDoc toQuizDoc(QuizDTO dto);
}
