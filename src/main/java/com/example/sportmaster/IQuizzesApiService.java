package com.example.sportmaster;

import com.example.sportmaster.openapi.model.QuizDTO;
import com.example.sportmaster.openapi.model.QuestionDTO;

import java.util.List;
public interface IQuizzesApiService {
    public QuizDoc quizzesQuizIdGet(Integer quizId);

    public boolean quizzesQuizIdDelete(Integer quizId);

    public QuizDTO quizzesQuizIdPut(Integer quizId, QuizDTO quiz);

    public List<QuizDoc> quizzesGet();

    public QuizDoc quizzesPost(QuizDTO quiz);

    public List<QuestionDoc> quizzesQuizIdQuestionsGet(Integer quizId);

    public QuestionDoc quizzesQuizIdQuestionsPost(Integer quizId, QuestionDTO question);

    public boolean quizzesQuizIdQuestionsQuestionIdDelete(Integer quizId, Integer questionId);

}
