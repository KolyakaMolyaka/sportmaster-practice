package com.example.sportmaster.repository.mappers;

import com.example.sportmaster.openapi.model.QuestionDTO;
import com.example.sportmaster.repository.models.QuestionPer;
import com.example.sportmaster.service.models.QuestionDoc;

public class QuestionDocToQuestionPerMapperImpl implements IQuestionDocToQuestionPerMapper {
    public QuestionPer toQuestionPer(QuestionDoc quizDoc) {
        QuestionPer questionPer;
        questionPer = new QuestionPer();

        questionPer.setId(quizDoc.getId());
        questionPer.setText(quizDoc.getText());
        questionPer.setHint(quizDoc.getHint());

        return questionPer;
    }

    public QuestionDoc toQuestionDoc(QuestionPer quizPer) {
        QuestionDoc questionDoc;
        questionDoc = new QuestionDoc();

        questionDoc.setId(quizPer.getId());
        questionDoc.setText(quizPer.getText());
        questionDoc.setHint(quizPer.getHint());

        return questionDoc;
    }
}
