package com.example.sportmaster;

import com.example.sportmaster.openapi.model.AnswerDTO;
import org.springframework.stereotype.Repository;

import java.security.InvalidKeyException;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Repository
public class AnswersRepository implements IAnswersRepository {
    HashMap<Integer, AnswerData> answersMap = new HashMap<>();

    private IAnswerDocToAnswerDataMapper answerDocToAnswerDataMapper = new AnswerDocToAnswerDataMapper();

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

    @Override
    public List<AnswerData> findAll(Integer questionId) {
        return answersMap.values()
                .stream()
                .filter(answerData -> Objects.equals(answerData.getQuestionId(), questionId))
                .toList();
    }

    @Override
    public AnswerData find(Integer answerId) {
        return answersMap.get(answerId);
    }

    @Override
    public AnswerData update(Integer answerId, AnswerData answerData) throws InvalidKeyException {
        if (!answersMap.containsKey(answerId)) throw new InvalidKeyException("Ответа с заданным ID не существует");
        answersMap.replace(answerId, answerData);
        return answersMap.get(answerId);
    }

    @Override
    public void delete(Integer answerId) {
        answersMap.remove(answerId);
    }
}
