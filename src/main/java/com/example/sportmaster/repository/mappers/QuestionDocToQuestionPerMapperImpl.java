package com.example.sportmaster.repository.mappers;

import com.example.sportmaster.repository.models.QuestionData;
import com.example.sportmaster.service.models.QuestionDoc;

public class QuestionDocToQuestionPerMapperImpl implements IQuestionDocToQuestionPerMapper {
    public QuestionData toQuestionPer(QuestionDoc questionDoc) {
        QuestionData questionData;
        questionData = new QuestionData();

        questionData.setId(questionDoc.getId());
        questionData.setText(questionDoc.getText());
        questionData.setCorrectOption(questionDoc.getCorrectOption());
        questionData.setOptions(questionDoc.getOptions());
        questionData.setHint(questionDoc.getHint());

        return questionData;
    }

    public QuestionDoc toQuestionDoc(QuestionData questionData) {
        QuestionDoc questionDoc;
        questionDoc = new QuestionDoc();

        questionDoc.setId(questionData.getId());
        questionDoc.setText(questionData.getText());
        questionDoc.setCorrectOption(questionData.getCorrectOption());
        questionDoc.setOptions(questionData.getOptions());
        questionDoc.setHint(questionData.getHint());

        return questionDoc;
    }
}
