package com.example.openapi.api;

import com.example.openapi.model.Question;
import com.example.openapi.model.Quiz;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * A delegate to be called by the {@link QuizzesApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-29T16:41:33.878459+03:00[Europe/Moscow]")
public interface QuizzesApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /quizzes : Получить список всех викторин
     *
     * @return Успешный ответ (status code 200)
     * @see QuizzesApi#quizzesGet
     */
    default ResponseEntity<List<Quiz>> quizzesGet() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"difficulty\" : \"Easy\", \"questions\" : [ { \"hint\" : \"Расставь шахматные фигуры и посчитай количество.\", \"options\" : [ \"[64,32,12,2]\", \"[64,32,12,2]\" ], \"id\" : \"1\", \"text\" : \"Сколько насчитывается шахматных фигур?\", \"correctOption\" : 32 }, { \"hint\" : \"Расставь шахматные фигуры и посчитай количество.\", \"options\" : [ \"[64,32,12,2]\", \"[64,32,12,2]\" ], \"id\" : \"1\", \"text\" : \"Сколько насчитывается шахматных фигур?\", \"correctOption\" : 32 } ], \"description\" : \"Шахматы - знакомая всем с детства игра, сочетающая в себе элементы искусства. Проверь свои знания и узнай, можно ли делить мир на черное и белое.\", \"created_at\" : \"2023-06-28T00:00:00.000+0000\", \"id\" : 1, \"title\" : \"Насколько хорошо ты знаешь шахматы!?\", \"explanation\" : \"В шахматах 16 черных и 16 белых фигур.\", \"category\" : \"Шахматы\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /quizzes : Создать новую викторину
     *
     * @param quiz  (required)
     * @return Успешное создание (status code 201)
     * @see QuizzesApi#quizzesPost
     */
    default ResponseEntity<Quiz> quizzesPost(Quiz quiz) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"difficulty\" : \"Easy\", \"questions\" : [ { \"hint\" : \"Расставь шахматные фигуры и посчитай количество.\", \"options\" : [ \"[64,32,12,2]\", \"[64,32,12,2]\" ], \"id\" : \"1\", \"text\" : \"Сколько насчитывается шахматных фигур?\", \"correctOption\" : 32 }, { \"hint\" : \"Расставь шахматные фигуры и посчитай количество.\", \"options\" : [ \"[64,32,12,2]\", \"[64,32,12,2]\" ], \"id\" : \"1\", \"text\" : \"Сколько насчитывается шахматных фигур?\", \"correctOption\" : 32 } ], \"description\" : \"Шахматы - знакомая всем с детства игра, сочетающая в себе элементы искусства. Проверь свои знания и узнай, можно ли делить мир на черное и белое.\", \"created_at\" : \"2023-06-28T00:00:00.000+0000\", \"id\" : 1, \"title\" : \"Насколько хорошо ты знаешь шахматы!?\", \"explanation\" : \"В шахматах 16 черных и 16 белых фигур.\", \"category\" : \"Шахматы\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /quizzes/{quizId} : Удалить викторину по ID
     *
     * @param quizId ID викторины (required)
     * @return Успешное удаление (status code 204)
     *         or Викторина не найдена (status code 404)
     * @see QuizzesApi#quizzesQuizIdDelete
     */
    default ResponseEntity<Void> quizzesQuizIdDelete(Integer quizId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /quizzes/{quizId} : Получить информацию о викторине по ID
     *
     * @param quizId ID викторины (required)
     * @return Успешный ответ (status code 200)
     *         or Викторина не найдена (status code 404)
     * @see QuizzesApi#quizzesQuizIdGet
     */
    default ResponseEntity<Quiz> quizzesQuizIdGet(Integer quizId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"difficulty\" : \"Easy\", \"questions\" : [ { \"hint\" : \"Расставь шахматные фигуры и посчитай количество.\", \"options\" : [ \"[64,32,12,2]\", \"[64,32,12,2]\" ], \"id\" : \"1\", \"text\" : \"Сколько насчитывается шахматных фигур?\", \"correctOption\" : 32 }, { \"hint\" : \"Расставь шахматные фигуры и посчитай количество.\", \"options\" : [ \"[64,32,12,2]\", \"[64,32,12,2]\" ], \"id\" : \"1\", \"text\" : \"Сколько насчитывается шахматных фигур?\", \"correctOption\" : 32 } ], \"description\" : \"Шахматы - знакомая всем с детства игра, сочетающая в себе элементы искусства. Проверь свои знания и узнай, можно ли делить мир на черное и белое.\", \"created_at\" : \"2023-06-28T00:00:00.000+0000\", \"id\" : 1, \"title\" : \"Насколько хорошо ты знаешь шахматы!?\", \"explanation\" : \"В шахматах 16 черных и 16 белых фигур.\", \"category\" : \"Шахматы\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /quizzes/{quizId} : Обновить информацию о викторине по ID
     *
     * @param quizId ID викторины (required)
     * @param quiz  (required)
     * @return Успешное обновление (status code 200)
     *         or Викторина не найдена (status code 404)
     * @see QuizzesApi#quizzesQuizIdPut
     */
    default ResponseEntity<Quiz> quizzesQuizIdPut(Integer quizId,
        Quiz quiz) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"difficulty\" : \"Easy\", \"questions\" : [ { \"hint\" : \"Расставь шахматные фигуры и посчитай количество.\", \"options\" : [ \"[64,32,12,2]\", \"[64,32,12,2]\" ], \"id\" : \"1\", \"text\" : \"Сколько насчитывается шахматных фигур?\", \"correctOption\" : 32 }, { \"hint\" : \"Расставь шахматные фигуры и посчитай количество.\", \"options\" : [ \"[64,32,12,2]\", \"[64,32,12,2]\" ], \"id\" : \"1\", \"text\" : \"Сколько насчитывается шахматных фигур?\", \"correctOption\" : 32 } ], \"description\" : \"Шахматы - знакомая всем с детства игра, сочетающая в себе элементы искусства. Проверь свои знания и узнай, можно ли делить мир на черное и белое.\", \"created_at\" : \"2023-06-28T00:00:00.000+0000\", \"id\" : 1, \"title\" : \"Насколько хорошо ты знаешь шахматы!?\", \"explanation\" : \"В шахматах 16 черных и 16 белых фигур.\", \"category\" : \"Шахматы\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /quizzes/{quizId}/questions : Получить список вопросов для викторины с указанным ID
     *
     * @param quizId ID викторины (required)
     * @return Успешный ответ (status code 200)
     *         or Викторина не найдена (status code 404)
     * @see QuizzesApi#quizzesQuizIdQuestionsGet
     */
    default ResponseEntity<List<Question>> quizzesQuizIdQuestionsGet(Integer quizId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"hint\" : \"Расставь шахматные фигуры и посчитай количество.\", \"options\" : [ \"[64,32,12,2]\", \"[64,32,12,2]\" ], \"id\" : \"1\", \"text\" : \"Сколько насчитывается шахматных фигур?\", \"correctOption\" : 32 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /quizzes/{quizId}/questions : Добавить новый вопрос в викторину с указанным ID
     *
     * @param quizId ID викторины (required)
     * @param question  (required)
     * @return Успешное создание (status code 201)
     *         or Викторина не найдена (status code 404)
     * @see QuizzesApi#quizzesQuizIdQuestionsPost
     */
    default ResponseEntity<Question> quizzesQuizIdQuestionsPost(Integer quizId,
        Question question) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"hint\" : \"Расставь шахматные фигуры и посчитай количество.\", \"options\" : [ \"[64,32,12,2]\", \"[64,32,12,2]\" ], \"id\" : \"1\", \"text\" : \"Сколько насчитывается шахматных фигур?\", \"correctOption\" : 32 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /quizzes/{quizId}/questions/{questionId} : Обновить информацию о вопросе в викторине с указанным ID
     *
     * @param quizId ID викторины (required)
     * @param questionId ID вопроса (required)
     * @param question  (required)
     * @return Успешное обновление (status code 200)
     * @see QuizzesApi#quizzesQuizIdQuestionsQuestionIdPut
     */
    default ResponseEntity<Void> quizzesQuizIdQuestionsQuestionIdPut(Integer quizId,
        Integer questionId,
        Question question) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
