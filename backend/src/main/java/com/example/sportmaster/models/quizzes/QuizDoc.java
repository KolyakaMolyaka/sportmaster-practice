package com.example.sportmaster.models.quizzes;

import lombok.Data;

import java.time.LocalDate;

@Data
public class QuizDoc {
    private Integer id;
    private String title;
    private String description;
    private LocalDate createdAt;
    private String category;
    private String difficulty;
}
