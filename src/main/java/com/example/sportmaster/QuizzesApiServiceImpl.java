package com.example.sportmaster;

import com.example.sportmaster.repository.IQuizzesRepository;
import com.example.sportmaster.repository.QuizzesRepositoryImpl;
import com.example.sportmaster.repository.mappers.IQuizDocToQuizPerMapper;
import com.example.sportmaster.repository.mappers.QuizDocToQuizPerMapperImpl;
import com.example.sportmaster.repository.models.QuizPer;
import com.example.sportmaster.service.*;
import com.example.sportmaster.service.models.QuestionDoc;
import com.example.sportmaster.service.models.QuizDoc;

import java.util.ArrayList;
import java.util.List;

public class QuizzesApiServiceImpl implements IQuizzesApiService {

    /* Использование анемичной модели */
    private final IGetQuestionsService getQuestionsService = new GetQuestionsServiceImpl();
    private final ICreateQuestionService createQuestionService = new CreateQuestionServiceImpl();
    private final IDeleteQuestionFromQuizService deleteQuestionFromQuizService = new DeleteQuestionFromQuizServiceImpl();
    private final IQuizDocToQuizPerMapper quizDocToQuizPerMapper = new QuizDocToQuizPerMapperImpl();
    private final IQuizzesRepository quizzesRepository = new QuizzesRepositoryImpl();


    public QuizDoc getQuiz(Integer quizId) {
        return quizDocToQuizPerMapper.toQuizDoc(
                quizzesRepository.getQuiz(quizId)
        );
    }

    public boolean deleteQuiz(Integer quizId) {
        return quizzesRepository.deleteQuiz(quizId);
    }

    public QuizDoc updateQuiz(Integer quizId, QuizDoc quiz) {
        return quizDocToQuizPerMapper.toQuizDoc(
                quizzesRepository.updateQuiz(quizId, quizDocToQuizPerMapper.toQuizPer(quiz))
        );
    }

    public List<QuizDoc> getQuizzes() {
        List<QuizPer> stubPerQuizzes = quizzesRepository.getQuizzes();
        List<QuizDoc> stubDocQuizzes = new ArrayList<>();
        for (QuizPer quizPer: stubPerQuizzes) {
            stubDocQuizzes.add(quizDocToQuizPerMapper.toQuizDoc(quizPer));
        }
        return stubDocQuizzes;
    }


    public QuizDoc createQuiz(QuizDoc quiz) {
        return quizDocToQuizPerMapper.toQuizDoc(
                quizzesRepository.createQuiz(quizDocToQuizPerMapper.toQuizPer(quiz))
        );
    }

    public List<QuestionDoc> getQuestionsFor(Integer quizId) {
        return getQuestionsService.getQuestionsFor(quizId);
    }

    public QuestionDoc createQuestionForQuiz(Integer quizId, QuestionDoc question) {
        return createQuestionService.createQuestionForQuiz(quizId, question);
    }

    public boolean deleteQuestionFromQuiz(Integer quizId, Integer questionId) {
        return deleteQuestionFromQuizService.deleteQuestionFromQuiz(quizId, questionId);
    }

}
