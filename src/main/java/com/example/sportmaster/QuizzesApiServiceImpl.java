package com.example.sportmaster;

import com.example.sportmaster.service.*;
import com.example.sportmaster.service.models.QuestionDoc;
import com.example.sportmaster.service.models.QuizDoc;

import java.util.List;

public class QuizzesApiServiceImpl implements IQuizzesApiService {

    /* Использование анемичной модели */
    private final IGetQuizByIdService getQuizByIdService = new GetQuizByIdServiceImpl();
    private final IDeleteQuizByIdService deleteQuizByIdService = new DeleteQuizByIdIServiceImpl();
    private final IPutQuizByIdService putQuizByIdService = new PutQuizByIdServiceImpl();
    private final IGetQuizzesService getQuizzesService = new GetQuizzesServiceImpl();
    private final IPostQuizService postQuizService = new PostQuizServiceImpl();
    private final IGetQuestionsByQuizIdService getQuestionsByQuizIdService = new GetQuestionsByQuizIdServiceImpl();
    private final IPostQuestionByQuizIdService postQuestionByQuizIdService = new PostQuestionByQuizIdServiceImpl();
    private final IDeleteQuizByIdQuestionByIdService deleteQuizByIdQuestionByIdService = new DeleteQuizByIdQuestionByIdServiceImpl();

    public QuizDoc quizzesQuizIdGet(Integer quizId) {
        return getQuizByIdService.quizzesQuizIdGet(quizId);
    }

    public boolean quizzesQuizIdDelete(Integer quizId) {
        return deleteQuizByIdService.quizzesQuizIdDelete(quizId);
    }

    public QuizDoc quizzesQuizIdPut(Integer quizId, QuizDoc quiz) {
        return putQuizByIdService.quizzesQuizIdPut(quizId, quiz);
    }

    public List<QuizDoc> quizzesGet() {
        return getQuizzesService.quizzesGet();
    }


    public QuizDoc quizzesPost(QuizDoc quiz) {
        return postQuizService.quizzesPost(quiz);
    }

    public List<QuestionDoc> quizzesQuizIdQuestionsGet(Integer quizId) {
        return getQuestionsByQuizIdService.quizzesQuizIdQuestionsGet(quizId);
    }

    public QuestionDoc quizzesQuizIdQuestionsPost(Integer quizId, QuestionDoc question) {
        return postQuestionByQuizIdService.quizzesQuizIdQuestionsPost(quizId, question);
    }

    public boolean quizzesQuizIdQuestionsQuestionIdDelete(Integer quizId, Integer questionId) {
        return deleteQuizByIdQuestionByIdService.quizzesQuizIdQuestionsQuestionIdDelete(quizId, questionId);
    }

}
