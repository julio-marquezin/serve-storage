package com.crea.storage.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = PasswordValidator.class)
@Target({ FIELD, PARAMETER })
@Retention(RUNTIME)
public @interface Password {
    String message() default "Senha inválida";
    int min() default 8;
    int max() default 20;

    boolean isRequiredNumber() default true;
    boolean isRequiredLetter() default true;
    boolean isRequiredSymbol() default true;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
