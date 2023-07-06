package com.example.sportmaster;

import com.example.sportmaster.openapi.model.QuestionDTO;
import org.springframework.stereotype.Repository;

import java.security.InvalidKeyException;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Repository
public class QuestionsRepository implements IQuestionsRepository {
    HashMap<Integer, QuestionData> questionMap = new HashMap<>();

    private IQuestionDocToQuestionDataMapper questionDocToQuestionDataMapper = new QuestionDocToQuestionDataMapper();

    private Integer id = 0;

    private Integer nextId() {
        id += 1;
        return id;
    }


    @Override
    public List<QuestionData> findAll(Integer quizId) {
        return questionMap.values()
                .stream().
                filter(questionData -> Objects.equals(questionData.getQuizId(), quizId))
                .toList();
    }

    @Override
    public QuestionData create(Integer quizId, QuestionData questionData) {
        Integer id = nextId();

        questionData.setQuizId(quizId);
        questionData.setId(id);
        questionMap.put(id, questionData);

        return questionData;
    }

    @Override
    public void delete(Integer questionId) throws InvalidKeyException {
        if (!questionMap.containsKey(questionId)) throw new InvalidKeyException("Вопрос с таким ID не существует");
        questionMap.remove(questionId);
    }

    @Override
    public void update(Integer questionId, QuestionData questionData) throws InvalidKeyException {
        if (!questionMap.containsKey(questionId)) throw new InvalidKeyException("Вопроса с таким ID не существует");
        questionMap.replace(questionId, questionData);
    }

    @Override
    public QuestionData find(Integer questionId) {
        return questionMap.get(questionId);
    }
}

