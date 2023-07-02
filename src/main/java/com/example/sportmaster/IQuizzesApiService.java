package com.example.sportmaster;

import com.example.sportmaster.service.QuestionDoc;
import com.example.sportmaster.service.QuizDoc;

import java.util.List;
public interface IQuizzesApiService {
    public QuizDoc quizzesQuizIdGet(Integer quizId);

    public boolean quizzesQuizIdDelete(Integer quizId);

    public QuizDoc quizzesQuizIdPut(Integer quizId, QuizDoc quiz);

    public List<QuizDoc> quizzesGet();

    public QuizDoc quizzesPost(QuizDoc quiz);

    public List<QuestionDoc> quizzesQuizIdQuestionsGet(Integer quizId);

    public QuestionDoc quizzesQuizIdQuestionsPost(Integer quizId, QuestionDoc question);

    public boolean quizzesQuizIdQuestionsQuestionIdDelete(Integer quizId, Integer questionId);

}
