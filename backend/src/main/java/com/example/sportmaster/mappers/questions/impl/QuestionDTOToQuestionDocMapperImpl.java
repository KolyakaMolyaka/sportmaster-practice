package com.example.sportmaster.mappers.questions.impl;

import com.example.sportmaster.mappers.answers.impl.AnswerDTOToAnswerDocMapperImpl;
import com.example.sportmaster.mappers.answers.AnswerDTOToAnswerDocMapper;
import com.example.sportmaster.mappers.questions.QuestionDTOToQuestionDocMapper;
import com.example.sportmaster.models.questions.QuestionDoc;
import com.example.sportmaster.openapi.model.QuestionDTO;

public class QuestionDTOToQuestionDocMapperImpl implements QuestionDTOToQuestionDocMapper {

    private AnswerDTOToAnswerDocMapper answerDTOToAnswerDocMapper = new AnswerDTOToAnswerDocMapperImpl();

    @Override
    public QuestionDTO toQuestionDTO(QuestionDoc doc) {
        if (doc == null) return null;
        QuestionDTO dto = new QuestionDTO();
        dto.setId(doc.getId());
        dto.setText(doc.getText());

        if (doc.getAnswers() != null) {
            dto.setAnswers(
                    doc.getAnswers()
                            .stream()
                            .map(answerDTOToAnswerDocMapper::toAnswerDTO)
                            .toList()
            );
        }

        return dto;
    }

    @Override
    public QuestionDoc toQuestionDoc(QuestionDTO dto) {
        if (dto == null) return null;
        QuestionDoc doc = new QuestionDoc();
        doc.setId(dto.getId());
        doc.setText(dto.getText());

        return doc;
    }
}
