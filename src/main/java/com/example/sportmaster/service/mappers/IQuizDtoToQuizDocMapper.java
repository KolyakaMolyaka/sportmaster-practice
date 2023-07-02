package com.example.sportmaster.service.mappers;

import com.example.sportmaster.openapi.model.QuizDTO;
import com.example.sportmaster.service.models.QuizDoc;

public interface IQuizDtoToQuizDocMapper {
    public QuizDTO toQuizDto(QuizDoc quizDoc);
    public QuizDoc toQuizDoc(QuizDTO quizDto);
}
