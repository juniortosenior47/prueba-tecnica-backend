package com.sysman.demo.decorator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.Enum;


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
            } catch (IllegalArgumentException e) {
                return false;
            }
        } else {
            return true; // Let @NotNull handle null values
        }
    }
}
