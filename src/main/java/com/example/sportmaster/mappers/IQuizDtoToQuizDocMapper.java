package com.example.sportmaster.mappers;

import com.example.sportmaster.openapi.model.QuizDTO;
import com.example.sportmaster.service.QuizDoc;

public interface IQuizDtoToQuizDocMapper {
    public QuizDTO toQuizDto(QuizDoc quizDoc);
    public QuizDoc toQuizDoc(QuizDTO quizDto);
}
