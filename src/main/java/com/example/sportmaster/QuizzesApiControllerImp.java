package com.example.sportmaster;

import com.example.sportmaster.openapi.api.QuizzesApi;
import com.example.sportmaster.openapi.model.Question;
import com.example.sportmaster.openapi.model.Quiz;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class QuizzesApiControllerImp implements QuizzesApi {

    private final IQuizzesApiService quizzesApiService = new QuizzesApiServiceImpl();

    public ResponseEntity<Quiz> quizzesQuizIdGet(@ApiParam(value = "ID викторины", required = true) @PathVariable("quizId") Integer quizId) {
        return quizzesApiService.quizzesQuizIdGet(quizId);
    }

    public ResponseEntity<Void> quizzesQuizIdDelete(@ApiParam(value = "ID викторины", required = true) @PathVariable("quizId") Integer quizId) {
        return quizzesApiService.quizzesQuizIdDelete(quizId);
    }

    public ResponseEntity<Quiz> quizzesQuizIdPut(@ApiParam(value = "ID викторины", required = true) @PathVariable("quizId") Integer quizId, @ApiParam(value = "", required = true) @Valid @RequestBody Quiz quiz) {
        return quizzesApiService.quizzesQuizIdPut(quizId, quiz);
    }

    public ResponseEntity<List<Quiz>> quizzesGet() {
        return quizzesApiService.quizzesGet();
    }

    public ResponseEntity<Quiz> quizzesPost(@ApiParam(value = "", required = true) @Valid @RequestBody Quiz quiz) {
        return quizzesApiService.quizzesPost(quiz);
    }

    public ResponseEntity<List<Question>> quizzesQuizIdQuestionsGet(@ApiParam(value = "ID викторины", required = true) @PathVariable("quizId") Integer quizId) {
        return quizzesApiService.quizzesQuizIdQuestionsGet(quizId);

    }

    public ResponseEntity<Question> quizzesQuizIdQuestionsPost(@ApiParam(value = "ID викторины", required = true) @PathVariable("quizId") Integer quizId, @ApiParam(value = "", required = true) @Valid @RequestBody Question question) {
        return quizzesApiService.quizzesQuizIdQuestionsPost(quizId, question);
    }

    public ResponseEntity<Void> quizzesQuizIdQuestionsQuestionIdDelete(@ApiParam(value = "ID викторины", required = true) @PathVariable("quizId") Integer quizId, @ApiParam(value = "ID вопроса", required = true) @PathVariable("questionId") Integer questionId) {
        return quizzesApiService.quizzesQuizIdQuestionsQuestionIdDelete(quizId, questionId);
    }


}
