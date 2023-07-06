package com.example.sportmaster;

import com.example.sportmaster.openapi.model.QuestionDTO;

public class QuestionData extends QuestionDTO {
    private Integer quizId;

    public Integer getQuizId() {
        return quizId;
    }

    public void setQuizId(Integer quizId) {
        this.quizId = quizId;
    }
}
