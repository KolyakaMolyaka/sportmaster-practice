package com.example.sportmaster.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AnswerData {
    private Integer id;
    private String text;
    private Boolean isCorrect;
    private Integer questionId;

    public AnswerData(Integer id, Integer questionId, String text, Boolean isCorrect) {
        this.id = id;
        this.questionId = questionId;
        this.text = text;
        this.isCorrect = isCorrect;

    }
}
