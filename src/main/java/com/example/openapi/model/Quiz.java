package com.example.openapi.model;

import java.util.Objects;
import com.example.openapi.model.Question;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Quiz
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-29T16:41:33.878459+03:00[Europe/Moscow]")
public class Quiz   {
  @JsonProperty("id")
  private Integer id;

  @JsonProperty("title")
  private String title;

  @JsonProperty("description")
  private String description;

  @JsonProperty("created_at")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE)
  private LocalDate createdAt;

  @JsonProperty("questions")
  @Valid
  private List<Question> questions = null;

  @JsonProperty("explanation")
  private String explanation;

  @JsonProperty("category")
  private String category;

  /**
   * Сложность викторины
   */
  public enum DifficultyEnum {
    EASY("Easy"),
    
    MEDIUM("Medium"),
    
    HARD("Hard");

    private String value;

    DifficultyEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static DifficultyEnum fromValue(String value) {
      for (DifficultyEnum b : DifficultyEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("difficulty")
  private DifficultyEnum difficulty;

  public Quiz id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Уникальный идентификатор викторины
   * @return id
  */
  @ApiModelProperty(example = "1", value = "Уникальный идентификатор викторины")


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Quiz title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Название викторины
   * @return title
  */
  @ApiModelProperty(example = "Насколько хорошо ты знаешь шахматы!?", value = "Название викторины")


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Quiz description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Описание викторины
   * @return description
  */
  @ApiModelProperty(example = "Шахматы - знакомая всем с детства игра, сочетающая в себе элементы искусства. Проверь свои знания и узнай, можно ли делить мир на черное и белое.", value = "Описание викторины")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Quiz createdAt(LocalDate createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /**
   * Дата создания викторины
   * @return createdAt
  */
  @ApiModelProperty(example = "Wed Jun 28 03:00:00 MSK 2023", value = "Дата создания викторины")

  @Valid

  public LocalDate getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDate createdAt) {
    this.createdAt = createdAt;
  }

  public Quiz questions(List<Question> questions) {
    this.questions = questions;
    return this;
  }

  public Quiz addQuestionsItem(Question questionsItem) {
    if (this.questions == null) {
      this.questions = new ArrayList<>();
    }
    this.questions.add(questionsItem);
    return this;
  }

  /**
   * Вопросы викторины
   * @return questions
  */
  @ApiModelProperty(value = "Вопросы викторины")

  @Valid

  public List<Question> getQuestions() {
    return questions;
  }

  public void setQuestions(List<Question> questions) {
    this.questions = questions;
  }

  public Quiz explanation(String explanation) {
    this.explanation = explanation;
    return this;
  }

  /**
   * Объяснение в случае неправильного ответа
   * @return explanation
  */
  @ApiModelProperty(example = "В шахматах 16 черных и 16 белых фигур.", value = "Объяснение в случае неправильного ответа")


  public String getExplanation() {
    return explanation;
  }

  public void setExplanation(String explanation) {
    this.explanation = explanation;
  }

  public Quiz category(String category) {
    this.category = category;
    return this;
  }

  /**
   * Категория викторины
   * @return category
  */
  @ApiModelProperty(example = "Шахматы", value = "Категория викторины")


  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public Quiz difficulty(DifficultyEnum difficulty) {
    this.difficulty = difficulty;
    return this;
  }

  /**
   * Сложность викторины
   * @return difficulty
  */
  @ApiModelProperty(value = "Сложность викторины")


  public DifficultyEnum getDifficulty() {
    return difficulty;
  }

  public void setDifficulty(DifficultyEnum difficulty) {
    this.difficulty = difficulty;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Quiz quiz = (Quiz) o;
    return Objects.equals(this.id, quiz.id) &&
        Objects.equals(this.title, quiz.title) &&
        Objects.equals(this.description, quiz.description) &&
        Objects.equals(this.createdAt, quiz.createdAt) &&
        Objects.equals(this.questions, quiz.questions) &&
        Objects.equals(this.explanation, quiz.explanation) &&
        Objects.equals(this.category, quiz.category) &&
        Objects.equals(this.difficulty, quiz.difficulty);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, description, createdAt, questions, explanation, category, difficulty);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Quiz {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    questions: ").append(toIndentedString(questions)).append("\n");
    sb.append("    explanation: ").append(toIndentedString(explanation)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    difficulty: ").append(toIndentedString(difficulty)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

