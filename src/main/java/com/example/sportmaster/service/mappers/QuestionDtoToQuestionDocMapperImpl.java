package com.example.sportmaster.service.mappers;

import com.example.sportmaster.openapi.model.QuestionDTO;
import com.example.sportmaster.service.models.QuestionDoc;

import java.util.Collections;

public class QuestionDtoToQuestionDocMapperImpl implements IQuestionDtoToQuestionDocMapper {

    public QuestionDTO toQuestionDto(QuestionDoc questionDoc) {
        QuestionDTO questionDto;
        questionDto = new QuestionDTO();

        questionDto.setId(questionDoc.getId());
        questionDto.setText(questionDoc.getText());
        questionDto.setCorrectOption(questionDoc.getCorrectOption());
        questionDto.setOptions(questionDoc.getOptions());
        questionDto.setHint(questionDoc.getHint());

        return questionDto;
    }

    public QuestionDoc toQuestionDoc(QuestionDTO questionDto) {
        QuestionDoc questionDoc;
        questionDoc = new QuestionDoc();

        questionDoc.setId(questionDto.getId());
        questionDoc.setText(questionDto.getText());
        questionDoc.setCorrectOption(questionDto.getCorrectOption());
        questionDoc.setOptions(questionDto.getOptions());
        questionDoc.setHint(questionDto.getHint());


        return questionDoc;
    }
}
