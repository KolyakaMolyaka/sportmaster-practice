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
        put(1, new QuestionData(1, 1, "Какое количество фигур находится на шахматной доске в начале партии?"));
        put(2, new QuestionData(2, 1, "Какой фигурой можно совершить \"Рокировку\"?"));
        put(3, new QuestionData(3, 1, "Какая фигура может ходить на любое количество клеток вперед, но только по вертикали или горизонтали?"));
        put(4, new QuestionData(4, 1, "Как называется ситуация, когда король находится под нападением, но не может сделать ни одного легального хода?"));

        put(5, new QuestionData(5, 2, "В какой стране родилась древняя греко-римская борьба?"));
        put(6, new QuestionData(6, 2, "Какой стиль борьбы характеризуется применением бросков и приемов на ноги?"));
        put(7, new QuestionData(7, 2, "Кто из этих борцов выиграл наибольшее количество золотых медалей на Олимпийских играх?"));
        put(8, new QuestionData(8, 2, "В каком году борьба стала официальным видом спорта на Олимпийских играх?"));

        put(9, new QuestionData(9, 3, "Какая из этих дистанций является олимпийской в плавании?"));
        put(10, new QuestionData(10, 3, "Стартуя на спине, каким образом пловец может проплыть дистанцию?"));
        put(11, new QuestionData(11, 3, "Какой стиль плавания считается самым быстрым?"));
        put(12, new QuestionData(12, 3, "Как называется специальное оборудование, используемое для тренировки плавания?"));

        put(13, new QuestionData(13, 4, "Какой олимпийский чемпион считается \"быстрейшим человеком в мире\"?"));
        put(14, new QuestionData(14, 4, "Каково расстояние в беге на 100 метров?"));
        put(15, new QuestionData(15, 4, "Какое максимальное количество попыток предоставляется каждому спортсмену в прыжках в высоту и в длину?"));
        put(16, new QuestionData(16, 4, "Какой рекорд принадлежит Жанне Лазарь?"));
        put(17, new QuestionData(17, 4, "Какой спортсмен установил мировой рекорд в метании копья?"));
        put(18, new QuestionData(18, 4, "Какое расстояние преодолевает спортсмен в беге на 800 метров?"));

    }};

    private IQuestionDocToQuestionDataMapper questionDocToQuestionDataMapper = new QuestionDocToQuestionDataMapper();


    private Integer id = 18; // текущий ID не будет включен в nextId()

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

