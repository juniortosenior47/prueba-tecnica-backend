package com.sysman.demo.model;


import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.annotation.Generated;

/**
 * APIResponses
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-06-12T16:21:40.542172662-05:00[America/Bogota]", comments = "Generator version: 7.13.0")
public class APIResponses {

  private String code;

  private String status;

  private String executed;

  @Valid
  private List<APIResponsesDataInner> data = new ArrayList<>();

  private String uri;

  private String process;

  public APIResponses() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public APIResponses(String code, String status, String executed, List<APIResponsesDataInner> data, String uri, String process) {
    this.code = code;
    this.status = status;
    this.executed = executed;
    this.data = data;
    this.uri = uri;
    this.process = process;
  }

  public APIResponses code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Get code
   * @return code
   */
  @NotNull 
  @Schema(name = "code", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("code")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public APIResponses status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
   */
  @NotNull 
  @Schema(name = "status", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("status")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public APIResponses executed(String executed) {
    this.executed = executed;
    return this;
  }

  /**
   * Get executed
   * @return executed
   */
  @NotNull 
  @Schema(name = "executed", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("executed")
  public String getExecuted() {
    return executed;
  }

  public void setExecuted(String executed) {
    this.executed = executed;
  }

  public APIResponses data(List<APIResponsesDataInner> data) {
    this.data = data;
    return this;
  }

  public APIResponses addDataItem(APIResponsesDataInner dataItem) {
    if (this.data == null) {
      this.data = new ArrayList<>();
    }
    this.data.add(dataItem);
    return this;
  }

  /**
   * Get data
   * @return data
   */
  @NotNull @Valid 
  @Schema(name = "data", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("data")
  public List<APIResponsesDataInner> getData() {
    return data;
  }

  public void setData(List<APIResponsesDataInner> data) {
    this.data = data;
  }

  public APIResponses uri(String uri) {
    this.uri = uri;
    return this;
  }

  /**
   * Get uri
   * @return uri
   */
  @NotNull 
  @Schema(name = "uri", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("uri")
  public String getUri() {
    return uri;
  }

  public void setUri(String uri) {
    this.uri = uri;
  }

  public APIResponses process(String process) {
    this.process = process;
    return this;
  }

  /**
   * Get process
   * @return process
   */
  @NotNull 
  @Schema(name = "process", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("process")
  public String getProcess() {
    return process;
  }

  public void setProcess(String process) {
    this.process = process;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    APIResponses apIResponses = (APIResponses) o;
    return Objects.equals(this.code, apIResponses.code) &&
        Objects.equals(this.status, apIResponses.status) &&
        Objects.equals(this.executed, apIResponses.executed) &&
        Objects.equals(this.data, apIResponses.data) &&
        Objects.equals(this.uri, apIResponses.uri) &&
        Objects.equals(this.process, apIResponses.process);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, status, executed, data, uri, process);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class APIResponses {\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    executed: ").append(toIndentedString(executed)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    uri: ").append(toIndentedString(uri)).append("\n");
    sb.append("    process: ").append(toIndentedString(process)).append("\n");
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

