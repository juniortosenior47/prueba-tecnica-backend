package com.sysman.demo.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sysman.demo.decorator.EnumValidator;
import com.sysman.demo.decorator.Status;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;



import jakarta.annotation.Generated;

/**
 * Material
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-06-12T16:21:40.542172662-05:00[America/Bogota]", comments = "Generator version: 7.13.0")
public class Material implements APIResponsesDataInner {

  @Valid
  private com.sysman.demo.model.City city;

  private String name;

  private String description;

  private String type;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private Date purchaseAt;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private Date saleAt;

  @EnumValidator(enumClass = Status.class, message = "Invalid status")
  private String status;

  public Material() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Material(com.sysman.demo.model.City city, String name, String description, String type, Date purchaseAt, Date saleAt, String status) {
    this.city = city;
    this.name = name;
    this.description = description;
    this.type = type;
    this.purchaseAt = purchaseAt;
    this.saleAt = saleAt;
    this.status = status;
  }

  public Material city(com.sysman.demo.model.City city) {
    this.city = city;
    return this;
  }

  /* public Material addCityItem(City cityItem) {
    if (this.city == null) {
      this.city = new ArrayList<>();
    }
    this.city.add(cityItem);
    return this;
  } */

  /**
   * Get city
   * @return city
   */
  @NotNull @Valid 
  @Schema(name = "city", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("city")
  public com.sysman.demo.model.City getCity() {
    return city;
  }

  public void setCity(com.sysman.demo.model.City city) {
    this.city = city;
  }

  public Material name(String name) {
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

  public Material description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
   */
  @NotNull 
  @Schema(name = "description", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Material type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
   */
  @NotNull 
  @Schema(name = "type", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("type")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Material purchaseAt(Date purchaseAt) {
    this.purchaseAt = purchaseAt;
    return this;
  }

  /**
   * Get purchaseAt
   * @return purchaseAt
   */
  @NotNull @Valid 
  @Schema(name = "purchaseAt", example = "2017-07-21T17:32:28Z", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("purchaseAt")
  public Date getPurchaseAt() {
    return purchaseAt;
  }

  public void setPurchaseAt(Date purchaseAt) {
    this.purchaseAt = purchaseAt;
  }

  public Material saleAt(Date saleAt) {
    this.saleAt = saleAt;
    return this;
  }

  /**
   * Get saleAt
   * @return saleAt
   */
  @NotNull @Valid 
  @Schema(name = "saleAt", example = "2017-07-21T17:32:28Z", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("saleAt")
  public Date getSaleAt() {
    return saleAt;
  }

  public void setSaleAt(Date saleAt) {
    this.saleAt = saleAt;
  }

  public Material status(String status) {
    this.status = status;
    return this;
  }

  /* public Material addStatusItem(Status statusItem) {
    if (this.status == null) {
      this.status = new ArrayList<>();
    }
    this.status.add(statusItem);
    return this;
  } */

  /**
   * Get status
   * @return status
   */
  @NotNull @Valid 
  @Schema(name = "status", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("status")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Material material = (Material) o;
    return Objects.equals(this.city, material.city) &&
        Objects.equals(this.name, material.name) &&
        Objects.equals(this.description, material.description) &&
        Objects.equals(this.type, material.type) &&
        Objects.equals(this.purchaseAt, material.purchaseAt) &&
        Objects.equals(this.saleAt, material.saleAt) &&
        Objects.equals(this.status, material.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(city, name, description, type, purchaseAt, saleAt, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Material {\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    purchaseAt: ").append(toIndentedString(purchaseAt)).append("\n");
    sb.append("    saleAt: ").append(toIndentedString(saleAt)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

