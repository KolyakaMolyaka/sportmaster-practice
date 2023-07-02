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
        return quizdoc;
    }

    public QuizDTO toQuizDto(QuizDoc quizdoc) {
        QuizDTO quizdto;
        quizdto = new QuizDTO();
        quizdto.setId(quizdoc.getId());
        quizdto.setTitle(quizdoc.getTitle());
        quizdto.setDescription(quizdoc.getDescription());
        return quizdto;
    }


}
