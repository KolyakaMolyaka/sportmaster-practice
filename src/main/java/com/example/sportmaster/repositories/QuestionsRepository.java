package com.example.sportmaster.repositories;

import com.example.sportmaster.models.QuizData;
import com.example.sportmaster.repositories.interfaces.IQuestionsRepository;
import com.example.sportmaster.models.QuestionData;
import com.example.sportmaster.mappers.QuestionDocToQuestionDataMapper;
import com.example.sportmaster.mappers.interfaces.IQuestionDocToQuestionDataMapper;
import org.springframework.stereotype.Repository;

import java.security.InvalidKeyException;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Repository
public class QuestionsRepository implements IQuestionsRepository {
    private HashMap<Integer, QuestionData> questionMap = new HashMap<Integer, QuestionData>() {{
        put(1, new QuestionData(1, 1, "Quiz #1, Answer #1"));
        put(2, new QuestionData(2, 1, "Quiz #1, Answer #2"));
        put(3, new QuestionData(3, 1, "Quiz #1, Answer #3"));

        put(4, new QuestionData(4, 2, "Quiz #2, Answer #1"));
        put(5, new QuestionData(5, 2, "Quiz #2, Answer #2"));
        put(6, new QuestionData(6, 2, "Quiz #2, Answer #3"));

        put(7, new QuestionData(7, 3, "Quiz #3, Answer #1"));
        put(8, new QuestionData(8, 3, "Quiz #3, Answer #2"));
        put(9, new QuestionData(9, 3, "Quiz #3, Answer #3"));
        put(10, new QuestionData(10, 3, "Quiz #3, Answer #4"));

        put(11, new QuestionData(11, 4, "Quiz #4, Answer #1"));
        put(12, new QuestionData(12, 4, "Quiz #4, Answer #2"));
        put(13, new QuestionData(13, 4, "Quiz #4, Answer #3"));

        put(14, new QuestionData(14, 5, "Quiz #5, Answer #1"));
        put(15, new QuestionData(15, 5, "Quiz #5, Answer #2"));


    }};

    private IQuestionDocToQuestionDataMapper questionDocToQuestionDataMapper = new QuestionDocToQuestionDataMapper();


    private Integer id = 15; // текущий ID не будет включен в nextId()

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

