package com.example.sportmaster;

import com.example.sportmaster.service.mappers.IQuestionDtoToQuestionDocMapper;
import com.example.sportmaster.service.mappers.IQuizDtoToQuizDocMapper;
import com.example.sportmaster.service.mappers.QuestionDtoToQuestionDocMapperImpl;
import com.example.sportmaster.service.mappers.QuizDtoToQuizDocMapperImpl;
import com.example.sportmaster.openapi.api.QuizzesApi;
import com.example.sportmaster.openapi.model.QuestionDTO;
import com.example.sportmaster.openapi.model.QuizDTO;
import com.example.sportmaster.service.models.QuestionDoc;
import com.example.sportmaster.service.models.QuizDoc;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@RestController
public class QuizzesApiControllerImp implements QuizzesApi {

    public final IQuizzesApiService quizzesApiService = new QuizzesApiServiceImpl();
    public final IQuizDtoToQuizDocMapper quizDtoToQuizDocMapper = new QuizDtoToQuizDocMapperImpl();
    public final IQuestionDtoToQuestionDocMapper questionDtoToQuestionDocMapper = new QuestionDtoToQuestionDocMapperImpl();

    @Override
    public ResponseEntity<QuizDTO> quizzesQuizIdGet(@ApiParam(value = "ID викторины", required = true) @PathVariable("quizId") Integer quizId) {
        QuizDTO q = quizDtoToQuizDocMapper.toQuizDto(
                quizzesApiService.getQuiz(quizId)
        );
        return ResponseEntity.ok(q);
    }

    @Override
    public ResponseEntity<Void> quizzesQuizIdDelete(@ApiParam(value = "ID викторины", required = true) @PathVariable("quizId") Integer quizId) {
        boolean deleteOperation = quizzesApiService.deleteQuiz(quizId);

        ResponseEntity<Void> response = ResponseEntity.badRequest().build();
        if (deleteOperation) response = ResponseEntity.ok().build();

        return response;

    }

    @Override
    public ResponseEntity<QuizDTO> quizzesQuizIdPut(@ApiParam(value = "ID викторины", required = true) @PathVariable("quizId") Integer quizId, @ApiParam(value = "", required = true) @Valid @RequestBody QuizDTO quiz) {

        String oldDesctiption = "old description";
        quiz.description(oldDesctiption);
        QuizDTO q = quizDtoToQuizDocMapper.toQuizDto(
                quizzesApiService.updateQuiz(quizId, quizDtoToQuizDocMapper.toQuizDoc(quiz))
        );
        if (quiz.getDescription().equals(q.getDescription())) return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(q);
    }

    @Override
    public ResponseEntity<List<QuizDTO>> quizzesGet() {
        List<QuizDTO> quizzesDTO = new ArrayList<>();
        List<QuizDoc> quizzesDoc = quizzesApiService.findAllQuizzes();
        // конвертируем QuizDoc в QuizDTO
        for (QuizDoc quiz : quizzesDoc) {
            quizzesDTO.add(quizDtoToQuizDocMapper.toQuizDto(quiz));
        }

        return ResponseEntity.ok(quizzesDTO);
    }

    @Override
    public ResponseEntity<QuizDTO> quizzesPost(@ApiParam(value = "", required = true) @Valid @RequestBody QuizDTO quiz) {
        QuizDTO quizDTO = quizDtoToQuizDocMapper.toQuizDto(
                quizzesApiService.createQuiz(quizDtoToQuizDocMapper.toQuizDoc(quiz))
        );
        return ResponseEntity.ok(quizDTO);
    }

    @Override
    public ResponseEntity<List<QuestionDTO>> quizzesQuizIdQuestionsGet(@ApiParam(value = "ID викторины", required = true) @PathVariable("quizId") Integer quizId) {
        List<QuestionDTO> questionsDTO = new ArrayList<>();
        List<QuestionDoc> questionsDoc = quizzesApiService.findAllQuestionsFor(quizId);
//         конвертируем questionsDoc в questionsDTO
        for (QuestionDoc q : questionsDoc) {
            questionsDTO.add(questionDtoToQuestionDocMapper.toQuestionDto(q));
        }

        return ResponseEntity.ok(questionsDTO);

    }

    @Override
    public ResponseEntity<QuestionDTO> quizzesQuizIdQuestionsPost(@ApiParam(value = "ID викторины", required = true) @PathVariable("quizId") Integer quizId, @ApiParam(value = "", required = true) @Valid @RequestBody QuestionDTO question) {

        QuestionDTO q = questionDtoToQuestionDocMapper.toQuestionDto(
                quizzesApiService.createQuestionForQuiz(quizId, questionDtoToQuestionDocMapper.toQuestionDoc(question))
        );
        return ResponseEntity.ok(q);
    }

    @Override
    public ResponseEntity<Void> quizzesQuizIdQuestionsQuestionIdDelete(@ApiParam(value = "ID викторины", required = true) @PathVariable("quizId") Integer quizId, @ApiParam(value = "ID вопроса", required = true) @PathVariable("questionId") Integer questionId) {
        boolean deleteOperation = quizzesApiService.deleteQuestionFromQuiz(quizId, questionId);

        ResponseEntity<Void> response = ResponseEntity.badRequest().build();
        if (deleteOperation) response = ResponseEntity.ok().build();

        return response;

    }


}
