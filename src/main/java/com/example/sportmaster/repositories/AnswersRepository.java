package com.example.sportmaster.repositories;

import com.example.sportmaster.models.AnswerData;
import com.example.sportmaster.models.QuestionData;
import com.example.sportmaster.repositories.interfaces.IAnswersRepository;
import com.example.sportmaster.mappers.AnswerDocToAnswerDataMapper;
import com.example.sportmaster.mappers.interfaces.IAnswerDocToAnswerDataMapper;
import org.springframework.stereotype.Repository;

import java.security.InvalidKeyException;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Repository
public class AnswersRepository implements IAnswersRepository {
    private HashMap<Integer, AnswerData> answersMap = new HashMap<Integer, AnswerData>() {{
        put(1, new AnswerData(1, 1, "Q1, Option 1, True answer #1", true));
        put(2, new AnswerData(2, 1, "Q1, Option 2, False answer #2", false));
        put(3, new AnswerData(3, 1, "Q1, Option 3, False answer #3", false));

        put(4, new AnswerData(4, 2, "Q1, Option 1, False answer #1", false));
        put(5, new AnswerData(5, 2, "Q1, Option 2, False answer #1", false));
        put(6, new AnswerData(6, 2, "Q1, Option 3, True answer #1", true));
        put(7, new AnswerData(7, 2, "Q1, Option 4, True answer #1", false));

        put(8, new AnswerData(8, 3, "Q1, Option 1, True answer #1", true));
        put(9, new AnswerData(9, 3, "Q1, Option 2, False answer #2", false));

        put(10, new AnswerData(10, 4, "Option 1, True answer #1", true));
        put(11, new AnswerData(11, 4, "Option 2, False answer #2", false));

        put(12, new AnswerData(12, 5, "Option 1, True answer #1", true));
        put(13, new AnswerData(13, 5, "Option 2, False answer #2", false));

        put(14, new AnswerData(14, 6, "Option 1, True answer #1", true));
        put(15, new AnswerData(15, 6, "Option 2, False answer #2", false));

        put(16, new AnswerData(16, 7, "Option 1, True answer #1", true));
        put(17, new AnswerData(17, 7, "Option 2, False answer #2", false));

        put(18, new AnswerData(18, 8, "Option 1, True answer #1", true));
        put(19, new AnswerData(19, 8, "Option 2, False answer #2", false));

        put(20, new AnswerData(20, 9, "Option 1, True answer #1", true));
        put(21, new AnswerData(21, 9, "Option 2, False answer #2", false));

        put(22, new AnswerData(22, 10, "Option 1, True answer #1", true));
        put(23, new AnswerData(23, 10, "Option 2, False answer #2", false));

        put(24, new AnswerData(24, 11, "Option 1, True answer #1", true));
        put(25, new AnswerData(25, 11, "Option 2, False answer #2", false));

        put(26, new AnswerData(26, 12, "Option 1, True answer #1", true));
        put(27, new AnswerData(27, 12, "Option 2, False answer #2", false));

    }};

    private IAnswerDocToAnswerDataMapper answerDocToAnswerDataMapper = new AnswerDocToAnswerDataMapper();

    private Integer id = 20; // текущий id не будет включен в nextId()

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
