package com.example.sportmaster.models;

import com.example.sportmaster.openapi.model.QuizDTO;
import lombok.Data;

import java.time.LocalDate;

@Data
public class QuizData {
    private Integer id;
    private String title;
    private String description;
    private LocalDate createdAt;
    private String category;
    private String difficulty;
}
