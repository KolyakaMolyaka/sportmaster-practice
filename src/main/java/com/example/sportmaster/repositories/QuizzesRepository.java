package com.example.sportmaster.repositories;

import com.example.sportmaster.repositories.interfaces.IQuizzesRepository;
import com.example.sportmaster.models.QuizData;
import org.springframework.stereotype.Repository;

import java.security.InvalidKeyException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class QuizzesRepository implements IQuizzesRepository {
    private HashMap<Integer, QuizData> quizzesMap = new HashMap<Integer, QuizData>() {{
        put(1, new QuizData(1, "Мастер шахмат",
                "Пройдите тест и проверьте свои знания в шахматах! Викторина \"Мастер шахмат\" представляет серию вопросов, связанных с правилами, стратегией и историей этой увлекательной игры.",
                "Шахматы", "Легкий"));
        put(2, new QuizData(2, "История борьбы",
                "В этой викторине вы сможете проверить свои знания об истории борьбы – одном из самых древних видов спорта. Будут представлены вопросы о различных стилях борьбы, великих борцах и их достижениях, а также интересные факты и исторические события, связанные с этим спортом. Готовы проверить свои навыки?",
                "Борьба", "Средний"));

        put(3, new QuizData(3, "Водные гонки",
                "Викторина \"Водные гонки\" предназначена для проверки ваших знаний о плавании. Ответьте на вопросы правильно и узнайте, насколько хорошо вы разбираетесь в мире водных гонок и плавания!",
                "Плавание", "Средний"));

        put(4, new QuizData(4, "Quiz #4", "Quiz #4 title", "Quiz #4 description", "Easy"));
        put(5, new QuizData(5, "Quiz #5", "Quiz #5 title", "Quiz #5 description", "Medium"));
    }};

    private Integer id = 5; // текущий ID не будет включен в nextId

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
