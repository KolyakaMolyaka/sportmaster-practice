package com.example.sportmaster;

import org.springframework.stereotype.Repository;

import java.security.InvalidKeyException;
import java.util.HashMap;
import java.util.List;

@Repository
public class QuizzesRepository implements IQuizzesRepository {
    private HashMap<Integer, QuizData> quizzesMap = new HashMap<>();

    private Integer id = 0;

    private Integer nextId() {
        id += 1;
        return id;
    }

    @Override
    public List<QuizData> findAll() {
        return quizzesMap.values().stream().toList();
    }

    @Override
    public QuizData create(QuizData quizData) {
        Integer id = nextId();
        quizData.setId(id);
        quizzesMap.put(id, quizData);
        return quizData;
    }

    @Override
    public void delete(Integer quizId) throws InvalidKeyException {
        if (quizzesMap.containsKey(quizId)) {
            quizzesMap.remove(quizId);
        } else {
            throw new InvalidKeyException("Викторины с указанным ID не существует");
        }

    }

    @Override
    public QuizData find(Integer quizId) {
        return quizzesMap.get(quizId);
    }

    @Override
    public QuizData update(Integer quizId, QuizData quizData) throws InvalidKeyException {
        if (!quizzesMap.containsKey(quizId)) throw new InvalidKeyException("Викторины с указанным ID не существует");

        quizData.setId(quizId);
        quizzesMap.replace(quizId, quizData);
        return quizData;
    }
}
