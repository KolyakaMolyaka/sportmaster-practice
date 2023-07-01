package com.example.sportmaster.service;

import com.example.sportmaster.openapi.model.QuestionDTO;

import java.util.List;
import java.util.Objects;

public class DeleteQuizByIdQuestionByIdServiceImpl implements IDeleteQuizByIdQuestionByIdService {
    public boolean quizzesQuizIdQuestionsQuestionIdDelete(Integer quizId, Integer questionId) {

        QuizDoc quiz = new QuizDoc();
        quiz.setId(quizId);

        QuestionDoc question = new QuestionDoc();
        question.setId(1);

        QuestionDoc question2 = new QuestionDoc();
        question2.setId(2);


        quiz.addQuestionsItem(question);
        quiz.addQuestionsItem(question2);

        // имитация удаления вопроса с ID=1
        // (вопрос с ID=2 продолжает существовать), т.е. bad request будет всегда, кроме запрсоа с ID=1

        List<QuestionDTO> questions = quiz.getQuestions();
        questions.remove(question);

        boolean deleteOperation = true;
        for (QuestionDTO q : questions) {
            if (Objects.equals(q.getId(), questionId)) {
                deleteOperation = false;
                break;
            }
        }
        return deleteOperation;
    }

}
