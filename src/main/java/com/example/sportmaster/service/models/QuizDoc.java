package com.example.sportmaster.service.models;

import lombok.Data;

import java.time.LocalDate;

@Data
public class QuizDoc  {
    private Integer id;
    private String title;
    private String description;
    private LocalDate createdAt;
    private String explanation;
    private String category;
}
