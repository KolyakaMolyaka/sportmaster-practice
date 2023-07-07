package com.example.sportmaster.services;

import com.example.sportmaster.mappers.AnswerDocToAnswerDataMapper;
import com.example.sportmaster.mappers.interfaces.IAnswerDocToAnswerDataMapper;
import com.example.sportmaster.models.AnswerDoc;
import com.example.sportmaster.repositories.interfaces.IAnswersRepository;
import com.example.sportmaster.repositories.interfaces.IQuestionsRepository;
import com.example.sportmaster.repositories.interfaces.IQuizzesRepository;
import com.example.sportmaster.models.QuestionDoc;
import com.example.sportmaster.mappers.QuestionDocToQuestionDataMapper;
import com.example.sportmaster.mappers.interfaces.IQuestionDocToQuestionDataMapper;
import com.example.sportmaster.services.interfaces.IQuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidKeyException;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionsService implements IQuestionsService {
    @Autowired
    private IQuestionsRepository questionsRepository;
    @Autowired
    private IQuizzesRepository quizzesRepository;

    @Autowired
    private IAnswersRepository answersRepository;

    private IQuestionDocToQuestionDataMapper questionDocToQuestionDataMapper = new QuestionDocToQuestionDataMapper();
    private IAnswerDocToAnswerDataMapper answerDocToAnswerDataMapper = new AnswerDocToAnswerDataMapper();

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

    }

    @Override
    public void updateQuestion(Integer questionId, QuestionDoc questionDoc) throws InvalidKeyException {
        questionsRepository.update(questionId, questionDocToQuestionDataMapper.toQuestionData(questionDoc));
    }

    @Override
    public List<QuestionDoc> findAllQuestions(Integer quizId) {
        List<QuestionDoc> questions = questionsRepository.findAll(quizId)
                .stream()
                .map(questionDocToQuestionDataMapper::toQuestionDoc).toList();

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
}
