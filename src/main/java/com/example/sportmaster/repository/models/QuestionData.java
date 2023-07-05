package com.example.sportmaster.repository.models;

import lombok.Data;

import java.util.List;

@Data
public class QuestionData {
    private Integer id;
    private String text;
    private String correctOption;
    private List<String> options = null;
    private String hint;
}
