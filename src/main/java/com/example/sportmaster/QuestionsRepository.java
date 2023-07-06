package com.example.sportmaster;

import com.example.sportmaster.openapi.model.QuestionDTO;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class QuestionsRepository implements IQuestionsRepository {
    HashMap<Integer, QuestionData> questionMap = new HashMap<>();

    private Integer id = 0;

    private Integer nextId() {
        id += 1;
        return id;
    }


    @Override
    public List<QuestionDTO> findAllQuestions(Integer quizId) {
//        List<QuestionData> questionDataList = questionMap.values()
//                .stream().
//                filter(questionData -> Objects.equals(questionData.getQuizId(), quizId))
//                .toList();
//
//        return
        return null;
    }
}
