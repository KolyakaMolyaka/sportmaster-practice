package com.example.sportmaster.mappers.quizzes;

import com.example.sportmaster.models.quizzes.QuizDoc;
import com.example.sportmaster.openapi.model.QuizDTO;

public interface QuizDTOToQuizDocMapper {
    public QuizDTO toQuizDTO(QuizDoc doc);
    public QuizDoc toQuizDoc(QuizDTO dto);
}
