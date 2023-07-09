package com.example.sportmaster.models.questions;

import com.example.sportmaster.models.answers.AnswerDoc;
import lombok.Data;

import java.util.List;

@Data
public class QuestionDoc {
    private Integer id;
    private String text;
    private List<AnswerDoc> answers;
}
