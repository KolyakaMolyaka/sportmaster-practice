package com.example.sportmaster.service;

import com.example.sportmaster.openapi.model.QuestionDTO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class QuestionDoc  {
    private Integer id;
    private String text;
    private String hint;
}
