package com.example.sportmaster.service;

import com.example.sportmaster.repository.IQuizzesRepository;
import com.example.sportmaster.repository.QuizzesRepositoryImpl;
import com.example.sportmaster.repository.mappers.IQuestionDocToQuestionPerMapper;
import com.example.sportmaster.repository.mappers.QuestionDocToQuestionPerMapperImpl;
import com.example.sportmaster.repository.models.QuestionPer;
import com.example.sportmaster.service.models.QuestionDoc;

import java.util.ArrayList;
import java.util.List;

public class GetQuestionsServiceImpl implements IGetQuestionsService {

    private final IQuizzesRepository quizzesRepository = new QuizzesRepositoryImpl();
    private final IQuestionDocToQuestionPerMapper questionDocToQuestionPerMapper = new QuestionDocToQuestionPerMapperImpl();

    public List<QuestionDoc> getQuestionsFor(Integer quizId) {
        List<QuestionPer> questionsPer = quizzesRepository.getQuestions(quizId);
        List<QuestionDoc> questionsDoc = new ArrayList<>();
        for (QuestionPer questionPer : questionsPer) {
            questionsDoc.add(questionDocToQuestionPerMapper.toQuestionDoc(questionPer));

        }
        return questionsDoc;
    }
}
