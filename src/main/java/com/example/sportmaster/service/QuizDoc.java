package com.example.sportmaster.service;

import com.example.sportmaster.openapi.model.QuizDTO;
import lombok.Data;

@Data
public class QuizDoc  {
    private Integer id;
    private String title;
    private String description;
}
