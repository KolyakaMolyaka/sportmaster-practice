package com.example.sportmaster;

import com.example.sportmaster.openapi.model.QuestionDTO;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class QuestionsRepository implements IQuestionsRepository {
    HashMap<Integer, QuestionDTO> questionMap = new HashMap<>();
}
