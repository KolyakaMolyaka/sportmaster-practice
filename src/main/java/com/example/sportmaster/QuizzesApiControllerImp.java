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
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class QuizzesApiControllerImp implements QuizzesApi {

    /* Пример реализации собственного метода */
    @Override
    public ResponseEntity<Quiz> quizzesQuizIdGet(@ApiParam(value = "ID викторины", required = true) @PathVariable("quizId") Integer quizId) {
        Quiz quiz = new Quiz();
        if (quizId == 1) {
            quiz.description("This is the first quiz");
        } else {
            quiz.description("This is not the first quiz :(");
        }
        return ResponseEntity.ok(quiz);
    }

    @Override
    public ResponseEntity<Void> quizzesQuizIdDelete(@ApiParam(value = "ID викторины", required = true) @PathVariable("quizId") Integer quizId) {
        // deleting quiz
        if (1 == quizId) return ResponseEntity.ok().build();

        // bad request
        return ResponseEntity.badRequest().build();
    }
    @Override
    public ResponseEntity<Quiz> quizzesQuizIdPut(@ApiParam(value = "ID викторины", required = true) @PathVariable("quizId") Integer quizId,@ApiParam(value = "", required = true) @Valid @RequestBody Quiz quiz) {
        // updating quiz
        quiz.description("updated description");
        return ResponseEntity.ok(quiz);
    }

    @Override
    public ResponseEntity<List<Quiz>> quizzesGet() {
        List<Quiz> stubQuizzes = new ArrayList<>();

        Quiz stubQuiz1 = new Quiz();
        stubQuiz1.title("Stub title - quiz 1");
        stubQuiz1.description("Stub description - quiz1");

        Quiz stubQuiz2 = new Quiz();
        stubQuiz2.title("Stub title - quiz 2");
        stubQuiz2.description("Stub description - quiz2");

        stubQuizzes.add(stubQuiz1);
        stubQuizzes.add(stubQuiz2);

        return ResponseEntity.ok(stubQuizzes);
    }

    @Override
    public ResponseEntity<Quiz> quizzesPost(@ApiParam(value = "", required = true) @Valid @RequestBody Quiz quiz) {
        quiz.title(quiz.getTitle().toUpperCase());
        quiz.description(quiz.getDescription().toUpperCase());
        return ResponseEntity.ok(quiz);
    }

    @Override
    public ResponseEntity<List<Question>> quizzesQuizIdQuestionsGet(@ApiParam(value = "ID викторины", required = true) @PathVariable("quizId") Integer quizId) {
        ArrayList<Question> questions = new ArrayList<>();

        Question q1 = new Question();
        Question q2 = new Question();

        q1.text("Question 1");
        q2.text("Question 2");

        questions.add(q1);
        questions.add(q2);

        return ResponseEntity.ok(questions);
    }

    @Override
    public ResponseEntity<Question> quizzesQuizIdQuestionsPost(@ApiParam(value = "ID викторины", required = true) @PathVariable("quizId") Integer quizId,@ApiParam(value = "", required = true) @Valid @RequestBody Question question) {
        question.setId(1);
        Quiz quiz = new Quiz();
        quiz.id(quizId);
        quiz.addQuestionsItem(question);
        for (Question q :  quiz.getQuestions()) {
            if (q.equals(question)) {
                return ResponseEntity.ok(question);
            }

        }
        return ResponseEntity.badRequest().build();
    }

    @Override
    public ResponseEntity<Void> quizzesQuizIdQuestionsQuestionIdDelete(@ApiParam(value = "ID викторины", required = true) @PathVariable("quizId") Integer quizId,@ApiParam(value = "ID вопроса", required = true) @PathVariable("questionId") Integer questionId) {

        Quiz quiz = new Quiz();
        quiz.setId(quizId);

        Question question = new Question();
        question.setId(1);

        Question question2 = new Question();
        question2.setId(2);


        quiz.addQuestionsItem(question);
        quiz.addQuestionsItem(question2);

        // имитация удаления вопроса с ID=1
        // (вопрос с ID=2 продолжает существовать), т.е. bad request будет всегда, кроме запрсоа с ID=1

        List<Question> questions = quiz.getQuestions();
        questions.remove(question);

        for (Question q: questions) {
            if (Objects.equals(q.getId(), questionId)) return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }


}
