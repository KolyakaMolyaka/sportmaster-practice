package com.example.sportmaster;

import com.example.sportmaster.openapi.model.Question;
import com.example.sportmaster.openapi.model.Quiz;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

public interface IQuizzesApiService {
    public ResponseEntity<Quiz> quizzesQuizIdGet(Integer quizId);

    public ResponseEntity<Void> quizzesQuizIdDelete(Integer quizId);

    public ResponseEntity<Quiz> quizzesQuizIdPut(Integer quizId, Quiz quiz);

    public ResponseEntity<List<Quiz>> quizzesGet();

    public ResponseEntity<Quiz> quizzesPost(Quiz quiz);

    public ResponseEntity<List<Question>> quizzesQuizIdQuestionsGet(Integer quizId);

    public ResponseEntity<Question> quizzesQuizIdQuestionsPost(Integer quizId, Question question);

    public ResponseEntity<Void> quizzesQuizIdQuestionsQuestionIdDelete(Integer quizId, Integer questionId);

}
