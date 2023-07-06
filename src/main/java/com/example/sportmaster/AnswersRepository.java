package com.example.sportmaster;

import com.example.sportmaster.openapi.model.AnswerDTO;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class AnswersRepository implements IAnswersRepository {
    HashMap<Integer, AnswerDTO> answersMap = new HashMap<>();

}
