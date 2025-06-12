package com.sysman.demo.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.annotation.Generated;

/**
 * APIMessage
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-06-12T16:21:40.542172662-05:00[America/Bogota]", comments = "Generator version: 7.13.0")
public class APIMessage implements APIResponsesDataInner {

  private String parameter;

  private String message;

  public APIMessage() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public APIMessage(String parameter, String message) {
    this.parameter = parameter;
    this.message = message;
  }

  public APIMessage parameter(String parameter) {
    this.parameter = parameter;
    return this;
  }

  /**
   * Get parameter
   * @return parameter
   */
  @NotNull 
  @Schema(name = "parameter", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("parameter")
  public String getParameter() {
    return parameter;
  }

  public void setParameter(String parameter) {
    this.parameter = parameter;
  }

  public APIMessage message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Get message
   * @return message
   */
  @NotNull 
  @Schema(name = "message", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("message")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    APIMessage apIMessage = (APIMessage) o;
    return Objects.equals(this.parameter, apIMessage.parameter) &&
        Objects.equals(this.message, apIMessage.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(parameter, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class APIMessage {\n");
    sb.append("    parameter: ").append(toIndentedString(parameter)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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

