package com.example.sportmaster.models.answers;

import lombok.Data;

@Data
public class AnswerDoc {
    private Integer id;
    private String text;
    private Boolean isCorrect;
}
