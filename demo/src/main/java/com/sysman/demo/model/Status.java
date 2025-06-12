package com.sysman.demo.model;

import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Gets or Sets Status
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-06-12T16:21:40.542172662-05:00[America/Bogota]", comments = "Generator version: 7.13.0")
public enum Status {
  
  ACTIVE("ACTIVE"),
  
  AVAILABLE("AVAILABLE"),
  
  ASSIGNED("ASSIGNED");

  private final String value;

  Status(String value) {
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
  public static Status fromValue(String value) {
    for (Status b : Status.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

