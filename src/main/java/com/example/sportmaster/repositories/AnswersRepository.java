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
        put(1, new AnswerData(1, 1, "24 фигуры", false));
        put(2, new AnswerData(2, 1, "28 фигур", false));
        put(3, new AnswerData(3, 1, "32 фигуры", true));
        put(4, new AnswerData(4, 1, "36 фигур", false));

        put(5, new AnswerData(5, 2, "Пешкой", false));
        put(6, new AnswerData(6, 2, "Слоном", false));
        put(7, new AnswerData(7, 2, "Конем", false));
        put(8, new AnswerData(8, 2, "Королем", true));

        put(9, new AnswerData(9, 3, "Ферзь", false));
        put(10, new AnswerData(10, 3, "Ладья", true));
        put(11, new AnswerData(11, 3, "Конь", false));
        put(12, new AnswerData(12, 3, "Король", false));

        put(13, new AnswerData(13, 4, "Мат", true));
        put(14, new AnswerData(14, 4, "Шах", false));
        put(15, new AnswerData(15, 4, "Пат", false));
        put(16, new AnswerData(16, 4, "Крепость", false));

        put(17, new AnswerData(17, 5, "Греция", true));
        put(18, new AnswerData(18, 5, "Рим", false));
        put(19, new AnswerData(19, 5, "Египет", false));
        put(20, new AnswerData(20, 5, "Китай", false));

        put(21, new AnswerData(21, 6, "Греко-римская борьба", false));
        put(22, new AnswerData(22, 6, "Вольная борьба", true));
        put(23, new AnswerData(23, 6, "Сумо", false));
        put(24, new AnswerData(24, 6, "Джудо", false));

        put(25, new AnswerData(25, 7, "Сергей Белоглазов", false));
        put(26, new AnswerData(26, 7, "Александр Карелин", true));
        put(27, new AnswerData(27, 7, "Джон Смит", false));
        put(28, new AnswerData(28, 7, "Лукас Рейс", false));

        put(29, new AnswerData(29, 8, "1896 год", false));
        put(30, new AnswerData(30, 8, "1904 год", false));
        put(31, new AnswerData(31, 8, "1924 год", true));
        put(32, new AnswerData(32, 8, "1936 год", false));

        put(33, new AnswerData(33, 9, "50 метров", false));
        put(34, new AnswerData(34, 9, "100 метров", false));
        put(35, new AnswerData(35, 9, "200 метров", true));
        put(36, new AnswerData(36, 9, "500 метров", false));

        put(37, new AnswerData(37, 10, "Баттерфляем", false));
        put(38, new AnswerData(38, 10, "Кролем", false));
        put(39, new AnswerData(39, 10, "Брассом", false));
        put(40, new AnswerData(40, 10, "На спине", true));

        put(41, new AnswerData(41, 11, "Кроль", false));
        put(42, new AnswerData(42, 11, "Баттерфляй", true));
        put(43, new AnswerData(43, 11, "Брасс", false));
        put(44, new AnswerData(44, 11, "Гребля на каноэ", false));

        put(45, new AnswerData(45, 12, "Гондола", false));
        put(46, new AnswerData(46, 12, "Рябинка", false));
        put(47, new AnswerData(47, 12, "Клетка", false));
        put(48, new AnswerData(48, 12, "Гидрокостюм", true));

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
