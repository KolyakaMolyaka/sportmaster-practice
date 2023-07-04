package com.example.sportmaster.service.models;

import lombok.Data;

import java.util.List;

@Data
public class QuestionDoc {
    private Integer id;
    private String text;
    private String correctOption;
    private List<String> options = null;
    private String hint;
}
