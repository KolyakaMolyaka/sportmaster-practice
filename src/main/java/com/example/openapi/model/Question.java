package com.example.openapi.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Question
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-06-29T16:41:33.878459+03:00[Europe/Moscow]")
public class Question   {
  @JsonProperty("id")
  private String id;

  @JsonProperty("text")
  private String text;

  @JsonProperty("options")
  @Valid
  private List<String> options = null;

  @JsonProperty("correctOption")
  private Integer correctOption;

  @JsonProperty("hint")
  private String hint;

  public Question id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Уникальный идентификатор вопроса
   * @return id
  */
  @ApiModelProperty(example = "1", value = "Уникальный идентификатор вопроса")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Question text(String text) {
    this.text = text;
    return this;
  }

  /**
   * Текст вопроса
   * @return text
  */
  @ApiModelProperty(example = "Сколько насчитывается шахматных фигур?", value = "Текст вопроса")


  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Question options(List<String> options) {
    this.options = options;
    return this;
  }

  public Question addOptionsItem(String optionsItem) {
    if (this.options == null) {
      this.options = new ArrayList<>();
    }
    this.options.add(optionsItem);
    return this;
  }

  /**
   * Варианты ответа
   * @return options
  */
  @ApiModelProperty(value = "Варианты ответа")


  public List<String> getOptions() {
    return options;
  }

  public void setOptions(List<String> options) {
    this.options = options;
  }

  public Question correctOption(Integer correctOption) {
    this.correctOption = correctOption;
    return this;
  }

  /**
   * Правильный ответ
   * @return correctOption
  */
  @ApiModelProperty(example = "32", value = "Правильный ответ")


  public Integer getCorrectOption() {
    return correctOption;
  }

  public void setCorrectOption(Integer correctOption) {
    this.correctOption = correctOption;
  }

  public Question hint(String hint) {
    this.hint = hint;
    return this;
  }

  /**
   * Подсказка к вопросу
   * @return hint
  */
  @ApiModelProperty(example = "Расставь шахматные фигуры и посчитай количество.", value = "Подсказка к вопросу")


  public String getHint() {
    return hint;
  }

  public void setHint(String hint) {
    this.hint = hint;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Question question = (Question) o;
    return Objects.equals(this.id, question.id) &&
        Objects.equals(this.text, question.text) &&
        Objects.equals(this.options, question.options) &&
        Objects.equals(this.correctOption, question.correctOption) &&
        Objects.equals(this.hint, question.hint);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, text, options, correctOption, hint);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Question {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    text: ").append(toIndentedString(text)).append("\n");
    sb.append("    options: ").append(toIndentedString(options)).append("\n");
    sb.append("    correctOption: ").append(toIndentedString(correctOption)).append("\n");
    sb.append("    hint: ").append(toIndentedString(hint)).append("\n");
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

