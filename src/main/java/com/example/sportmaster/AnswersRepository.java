package com.example.sportmaster;

import com.example.sportmaster.openapi.model.AnswerDTO;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class AnswersRepository implements IAnswersRepository {
    HashMap<Integer, AnswerData> answersMap = new HashMap<>();

    private Integer id = 0;
    private Integer nextId() {
        id += 1;
        return id;
    }
    @Override
    public AnswerData create(Integer questionId, AnswerData answerData) {
        Integer id = nextId();

        answerData.setId(id);
        answerData.setQuestionId(questionId);

        answersMap.put(id, answerData);
        return answerData;
    }
}
