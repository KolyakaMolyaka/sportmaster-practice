package com.example.sportmaster;

import com.example.sportmaster.openapi.model.QuestionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionsService implements IQuestionsService {
    @Autowired
    private IQuestionsRepository questionsRepository;
    @Autowired
    private IAnswersRepository answersRepository;
    @Autowired
    private IQuizzesRepository quizzesRepository;
    @Autowired
    private IQuestionsService questionsService;

    private IQuestionDocToQuestionDataMapper questionDocToQuestionDataMapper = new QuestionDocToQuestionDataMapper();

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
    public void deleteQuestion(Integer questionId) {

    }

    @Override
    public void updateQuestion(Integer questionId, QuestionDoc questionDoc) {

    }

    @Override
    public List<QuestionDoc> findAllQuestions(Integer quizId) {
        return questionsRepository.findAll(quizId)
                .stream()
                .map(questionDocToQuestionDataMapper::toQuestionDoc).toList();
    }
}
