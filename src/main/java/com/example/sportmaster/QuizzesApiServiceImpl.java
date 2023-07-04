package com.example.sportmaster;

import com.example.sportmaster.service.*;
import com.example.sportmaster.service.models.QuestionDoc;
import com.example.sportmaster.service.models.QuizDoc;

import java.util.List;

public class QuizzesApiServiceImpl implements IQuizzesApiService {

    /* Использование анемичной модели */
    private final IGetQuizService getQuizByIdService = new GetQuizServiceImpl();
    private final IDeleteQuizService deleteQuizByIdService = new DeleteQuizByIdIServiceImpl();
    private final IUpdateQuizdService putQuizByIdService = new UpdateQuizServiceImpl();
    private final IGetQuizzesService getQuizzesService = new GetQuizzesServiceImpl();
    private final ICreateQuizService postQuizService = new CreateQuizServiceImpl();
    private final IGetQuestionsService getQuestionsByQuizIdService = new GetQuestionsServiceImpl();
    private final ICreateQuestionService postQuestionByQuizIdService = new CreateQuestionServiceImpl();
    private final IDeleteQuestionFromQuizService deleteQuizByIdQuestionByIdService = new DeleteQuestionFromQuizServiceImpl();

    public QuizDoc getQuiz(Integer quizId) {
        return getQuizByIdService.getQuiz(quizId);
    }

    public boolean deleteQuiz(Integer quizId) {
        return deleteQuizByIdService.deleteQuiz(quizId);
    }

    public QuizDoc updateQuiz(Integer quizId, QuizDoc quiz) {
        return putQuizByIdService.quizzesQuizIdPut(quizId, quiz);
    }

    public List<QuizDoc> getQuizzes() {
        return getQuizzesService.getQuizzes();
    }


    public QuizDoc createQuiz(QuizDoc quiz) {
        return postQuizService.createQuiz(quiz);
    }

    public List<QuestionDoc> getQuestionsFor(Integer quizId) {
        return getQuestionsByQuizIdService.getQuestionsFor(quizId);
    }

    public QuestionDoc createQuestionForQuiz(Integer quizId, QuestionDoc question) {
        return postQuestionByQuizIdService.createQuestionForQuiz(quizId, question);
    }

    public boolean deleteQuestionFromQuiz(Integer quizId, Integer questionId) {
        return deleteQuizByIdQuestionByIdService.deleteQuestionFromQuiz(quizId, questionId);
    }

}
