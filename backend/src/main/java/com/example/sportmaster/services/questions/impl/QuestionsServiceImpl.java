package com.example.sportmaster.services.questions.impl;

import com.example.sportmaster.mappers.AnswerDocToAnswerDataMapperImpl;
import com.example.sportmaster.mappers.QuestionDocToQuestionDataMapperImpl;
import com.example.sportmaster.mappers.interfaces.AnswerDocToAnswerDataMapper;
import com.example.sportmaster.models.answers.AnswerDoc;
import com.example.sportmaster.repositories.answers.AnswersRepository;
import com.example.sportmaster.repositories.questions.QuestionsRepository;
import com.example.sportmaster.repositories.quizzes.QuizzesRepository;
import com.example.sportmaster.models.questions.QuestionDoc;
import com.example.sportmaster.mappers.interfaces.QuestionDocToQuestionDataMapper;
import com.example.sportmaster.services.answers.AnswersService;
import com.example.sportmaster.services.questions.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidKeyException;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionsServiceImpl implements QuestionsService {
    @Autowired
    private QuestionsRepository questionsRepository;
    @Autowired
    private QuizzesRepository quizzesRepository;
    @Autowired
    private AnswersRepository answersRepository;


    @Autowired
    private AnswersService answersService;

    private QuestionDocToQuestionDataMapper questionDocToQuestionDataMapper = new QuestionDocToQuestionDataMapperImpl();
    private AnswerDocToAnswerDataMapper answerDocToAnswerDataMapper = new AnswerDocToAnswerDataMapperImpl();

    @Override
    public void deleteAnswer(Integer questionId, Integer answerId) {
    }

    @Override
    public AnswerDoc findAnswer(Integer questionId, Integer answerId) {
        return null;
    }

    @Override
    public AnswerDoc updateAnswer(Integer questionId, Integer answerId, AnswerDoc answerDoc) {
        return null;
    }

    @Override
    public List<AnswerDoc> findAllAnswers(Integer questionId) {
        return null;
    }

    @Override
    public List<AnswerDoc> createAnswer(Integer questionId, AnswerDoc answerDoc) {
        return null;
    }

    @Override
    public void deleteQuestion(Integer questionId) throws InvalidKeyException {
        questionsRepository.delete(questionId);
        answersService.deleteAnswersForQuestion(questionId);

    }

    @Override
    public void updateQuestion(Integer questionId, QuestionDoc questionDoc) throws InvalidKeyException {
        questionsRepository.update(questionId, questionDocToQuestionDataMapper.toQuestionData(questionDoc));
    }

    @Override
    public List<QuestionDoc> findAllQuestions(Integer quizId) {
        // получение --вопросов-- для викторины с id == quizId
        List<QuestionDoc> questions = questionsRepository.findAll(quizId)
                .stream()
                .map(questionDocToQuestionDataMapper::toQuestionDoc).toList();

        // получение --ответов на вопросы-- для викторины с id == quizId
        List<QuestionDoc> questionsWithAnswers = new ArrayList<>();
        for (QuestionDoc question: questions) {
            question.setAnswers(
                    answersRepository.findAll(question.getId())
                            .stream()
                            .map(answerDocToAnswerDataMapper::toAnswerDoc)
                            .toList()
            );
            questionsWithAnswers.add(question);
        }

        return questionsWithAnswers;
    }

    @Override
    public QuestionDoc createQuestion(Integer quizId, QuestionDoc questionDoc) throws InvalidKeyException {
        /* проверка, есть ли викторина с заданным id (если есть - к ней будет привязан вопрос) */
        if (quizzesRepository.find(quizId) == null)
            throw new InvalidKeyException("Викторины с указанным ID не существует");

        return questionDocToQuestionDataMapper.toQuestionDoc(
                questionsRepository.create(quizId, questionDocToQuestionDataMapper.toQuestionData(questionDoc))
        );
    }

    @Override
    public void deleteForQuiz(Integer quizId) {
        List<Integer> questionIdsToRemove = questionsRepository.deleteQuestions(quizId);
        for (Integer questionId: questionIdsToRemove) {
            answersService.deleteAnswersForQuestion(questionId);
        }
    }
}
