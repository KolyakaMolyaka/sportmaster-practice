package com.example.sportmaster.service.mappers;

import com.example.sportmaster.openapi.model.QuizDTO;
import com.example.sportmaster.service.models.QuizDoc;

public class QuizDtoToQuizDocMapperImpl implements IQuizDtoToQuizDocMapper {
    public QuizDoc toQuizDoc(QuizDTO quizdto) {
        QuizDoc quizdoc;
        quizdoc = new QuizDoc();
        quizdoc.setId(quizdto.getId());
        quizdoc.setTitle(quizdto.getTitle());
        quizdoc.setDescription(quizdto.getDescription());
        quizdoc.setCreatedAt(quizdto.getCreatedAt());
        quizdoc.setExplanation(quizdto.getExplanation());
        quizdoc.setCategory(quizdto.getCategory());
        return quizdoc;
    }

    public QuizDTO toQuizDto(QuizDoc quizdoc) {
        QuizDTO quizdto;
        quizdto = new QuizDTO();
        quizdto.setId(quizdoc.getId());
        quizdto.setTitle(quizdoc.getTitle());
        quizdto.setDescription(quizdoc.getDescription());
        quizdto.setCreatedAt(quizdoc.getCreatedAt());
        quizdto.setExplanation(quizdoc.getExplanation());
        quizdto.setCategory(quizdoc.getCategory());
        return quizdto;
    }


}
