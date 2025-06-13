package com.sysman.demo.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
//import java.util.ArrayList;
//import java.util.List;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.annotation.Generated;

/**
 * City
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-06-12T16:21:40.542172662-05:00[America/Bogota]", comments = "Generator version: 7.13.0")
public class City {

  @Valid
  private com.sysman.demo.model.Counties counties = new com.sysman.demo.model.Counties();

  private String code;

  private String name;

  public City() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public City(com.sysman.demo.model.Counties counties, String code, String name) {
    this.counties = counties;
    this.code = code;
    this.name = name;
  }

  public City counties(com.sysman.demo.model.Counties counties) {
    this.counties = counties;
    return this;
  }

  /* public City addCountiesItem(Counties countiesItem) {
    if (this.counties == null) {
      this.counties = new com.sysman.demo.model.Counties();
    }
    this.counties.add(countiesItem);
    return this;
  } */

  /**
   * Get counties
   * @return counties
   */
  @NotNull @Valid 
  @Schema(name = "counties", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("counties")
  public com.sysman.demo.model.Counties getCounties() {
    return counties;
  }

  public void setCounties(com.sysman.demo.model.Counties counties) {
    this.counties = counties;
  }

  public City code(String code) {
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

  public City name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   */
  @NotNull 
  @Schema(name = "name", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    City city = (City) o;
    return Objects.equals(this.counties, city.counties) &&
        Objects.equals(this.code, city.code) &&
        Objects.equals(this.name, city.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(counties, code, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class City {\n");
    sb.append("    counties: ").append(toIndentedString(counties)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

