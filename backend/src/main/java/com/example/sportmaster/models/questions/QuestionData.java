package com.example.sportmaster.models.questions;

import com.example.sportmaster.openapi.model.QuestionDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class QuestionData {
    private Integer id;
    private Integer quizId;
    private String text;

    public QuestionData(Integer id, Integer quizId, String text) {
        this.id = id;
        this.quizId = quizId;
        this.text = text;
    }
}
