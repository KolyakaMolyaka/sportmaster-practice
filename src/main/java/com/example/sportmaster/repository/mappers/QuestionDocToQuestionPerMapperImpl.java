package com.example.sportmaster.repository.mappers;

import com.example.sportmaster.openapi.model.QuestionDTO;
import com.example.sportmaster.repository.models.QuestionPer;
import com.example.sportmaster.service.models.QuestionDoc;

public class QuestionDocToQuestionPerMapperImpl implements IQuestionDocToQuestionPerMapper {
    public QuestionPer toQuestionPer(QuestionDoc questionDoc) {
        QuestionPer questionPer;
        questionPer = new QuestionPer();

        questionPer.setId(questionDoc.getId());
        questionPer.setText(questionDoc.getText());
        questionPer.setCorrectOption(questionDoc.getCorrectOption());
        questionPer.setOptions(questionDoc.getOptions());
        questionPer.setHint(questionDoc.getHint());

        return questionPer;
    }

    public QuestionDoc toQuestionDoc(QuestionPer questionPer) {
        QuestionDoc questionDoc;
        questionDoc = new QuestionDoc();

        questionDoc.setId(questionPer.getId());
        questionDoc.setText(questionPer.getText());
        questionDoc.setCorrectOption(questionPer.getCorrectOption());
        questionDoc.setOptions(questionPer.getOptions());
        questionDoc.setHint(questionPer.getHint());

        return questionDoc;
    }
}
