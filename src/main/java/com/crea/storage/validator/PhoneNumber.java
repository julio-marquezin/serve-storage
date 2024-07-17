package com.crea.storage.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PhoneNumberValidator.class)
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface PhoneNumber {

    String message() default "Formato de telefone inválido";

    boolean isRequiredCountry() default true;
    boolean isRequiredAreaCode() default true;
    boolean isRequiredLocalNumber() default true;
    boolean isRequiredNumber() default true;

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
