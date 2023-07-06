package com.example.sportmaster;

import com.example.sportmaster.openapi.model.QuizDTO;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class QuizzesRepository implements IQuizzesRepository {
    HashMap<Integer, QuizDTO> quizzesMap = new HashMap<>();

    @Override
    public List<QuizDTO> findAll() {
        return quizzesMap.values().stream().toList();
    }
}
