package com.example.sportmaster.service;


import com.example.sportmaster.repository.IQuizzesRepository;
import com.example.sportmaster.repository.QuizzesRepositoryImpl;
import com.example.sportmaster.repository.mappers.IQuestionDocToQuestionPerMapper;
import com.example.sportmaster.repository.mappers.QuestionDocToQuestionPerMapperImpl;
import com.example.sportmaster.service.models.QuestionDoc;

public class PostQuestionByQuizIdServiceImpl implements IPostQuestionByQuizIdService {
    private final IQuizzesRepository quizzesRepository = new QuizzesRepositoryImpl();
    private final IQuestionDocToQuestionPerMapper questionDocToQuestionPerMapper = new QuestionDocToQuestionPerMapperImpl();
    public QuestionDoc quizzesQuizIdQuestionsPost(Integer quizId, QuestionDoc question) {
        return questionDocToQuestionPerMapper.toQuestionDoc(
                quizzesRepository.quizzesQuizIdQuestionsPost(
                        quizId, questionDocToQuestionPerMapper.toQuestionPer(question))
        ) ;
    }
}
