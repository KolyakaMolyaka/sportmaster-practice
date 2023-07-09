package com.example.sportmaster.models;

import com.example.sportmaster.openapi.model.QuizDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class QuizData {
    private Integer id;
    private String title;
    private String description;
    private LocalDate createdAt;
    private String category;
    private String difficulty;

    public QuizData(Integer id, String title, String description, String category, String difficulty) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.difficulty = difficulty;
        this.createdAt = LocalDate.now();

    }
}
