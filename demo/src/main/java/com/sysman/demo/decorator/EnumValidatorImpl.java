package com.sysman.demo.decorator;

import com.fasterxml.jackson.annotation.JsonValue;

import jakarta.annotation.Generated;
import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;
import jakarta.validation.constraints.NotNull;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.reflect.TypeVariable;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.lang.Enum;


import com.fasterxml.jackson.annotation.JsonCreator;

// Validator Implementation
public class EnumValidatorImpl implements ConstraintValidator<EnumValidator, String> {
    private Class<? extends Enum<?>> enumClass;

    @Override
    public void initialize(EnumValidator constraintAnnotation) {
        this.enumClass = constraintAnnotation.enumClass();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // Let @NotNull handle null values
        }
        if (enumClass != null) {
            try {
                Enum<?>[] valores = (Enum<?>[]) enumClass.getEnumConstants();
                return true;
                //System.out.println("Valores del enum: " + Arrays.toString(valores));
            } catch (IllegalArgumentException e) {
                return false;
            }
        } else {
            System.out.println("La clase enum es null.");
            return true; // Let @NotNull handle null values
        }
    }
}
 /* 
  // Enum
  public enum Status {
  PENDING,
  APPROVED,
  REJECTED
  }

 * // DTO
 * public class MyDTO {
 * 
 * @EnumValidator(enumClass = Status.class, message = "Invalid status")
 * private String status;
 * // Other fields, getters, setters
 * }
 * 
 * // Controller
 * 
 * @PostMapping("/example")
 * public ResponseEntity<?> example(@Valid @RequestBody MyDTO dto) {
 * // Handle request with validated DTO
 */
