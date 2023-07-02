package com.example.sportmaster.service;

import com.example.sportmaster.repository.IQuizzesRepository;
import com.example.sportmaster.repository.QuizzesRepositoryImpl;
import com.example.sportmaster.repository.mappers.IQuestionDocToQuestionPerMapper;
import com.example.sportmaster.repository.mappers.IQuizDocToQuizPerMapper;
import com.example.sportmaster.repository.mappers.QuestionDocToQuestionPerMapperImpl;
import com.example.sportmaster.repository.mappers.QuizDocToQuizPerMapperImpl;
import com.example.sportmaster.repository.models.QuestionPer;
import com.example.sportmaster.service.models.QuestionDoc;

import java.util.ArrayList;
import java.util.List;

public class GetQuestionsByQuizIdServiceImpl implements IGetQuestionsByQuizIdService {

    private final IQuizzesRepository quizzesRepository = new QuizzesRepositoryImpl();
    private final IQuestionDocToQuestionPerMapper questionDocToQuestionPerMapper = new QuestionDocToQuestionPerMapperImpl();

    public List<QuestionDoc> quizzesQuizIdQuestionsGet(Integer quizId) {
        List<QuestionPer> questionsPer = quizzesRepository.quizzesQuizIdQuestionsGet(quizId);
        List<QuestionDoc> questionsDoc = new ArrayList<>();
        for (QuestionPer questionPer : questionsPer) {
            questionsDoc.add(questionDocToQuestionPerMapper.toQuestionDoc(questionPer));

        }
        return questionsDoc;
    }
}
