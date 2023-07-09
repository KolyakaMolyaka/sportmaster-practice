package com.example.sportmaster.models;

import lombok.Data;

@Data
public class AnswerDoc {
    private Integer id;
    private String text;
    private Boolean isCorrect;
}
