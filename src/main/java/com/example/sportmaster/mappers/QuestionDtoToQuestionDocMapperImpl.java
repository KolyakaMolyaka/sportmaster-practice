package com.example.sportmaster.mappers;

import com.example.sportmaster.openapi.model.QuestionDTO;
import com.example.sportmaster.service.QuestionDoc;

public class QuestionDtoToQuestionDocMapperImpl implements IQuestionDtoToQuestionDocMapper {

    public QuestionDTO toQuestionDto(QuestionDoc questionDoc) {
        QuestionDTO questionDto;
        questionDto = new QuestionDTO();

        questionDto.setId(questionDoc.getId());
        questionDto.setText(questionDoc.getText());
        questionDto.setHint(questionDoc.getHint());

        return questionDto;
    }

    public QuestionDoc toQuestionDoc(QuestionDTO questionDto) {
        QuestionDoc questionDoc;
        questionDoc = new QuestionDoc();

        questionDoc.setId(questionDto.getId());
        questionDoc.setText(questionDto.getText());
        questionDoc.setHint(questionDto.getHint());

        return questionDoc;
    }
}
