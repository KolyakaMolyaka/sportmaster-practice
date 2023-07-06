package com.example.sportmaster;

import lombok.Data;

@Data
public class AnswerData {
    private Integer id;
    private String text;
    private Boolean isCorrect;
    private Integer questionId;
}
