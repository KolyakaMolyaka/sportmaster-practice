package com.example.sportmaster.models;

import lombok.Data;

import java.util.List;

@Data
public class QuestionDoc {
    private Integer id;
    private String text;
    private List<AnswerDoc> answers;
}
