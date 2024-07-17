package com.crea.storage.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<Password, String> {

    private int min;
    private int max;

    private boolean isRequiredNumber;
    private boolean isRequiredLetter;
    private boolean isRequiredSymbol;

    @Override
    public void initialize(Password constraintAnnotation) {
        this.min = constraintAnnotation.min();
        this.max = constraintAnnotation.max();

        this.isRequiredNumber = constraintAnnotation.isRequiredNumber();
        this.isRequiredLetter = constraintAnnotation.isRequiredLetter();
        this.isRequiredSymbol = constraintAnnotation.isRequiredSymbol();
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        if (password == null || password.length() < min || password.length() > max) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("A senha deve ter entre 8 e 20 caracteres").addConstraintViolation();
            return false;
        }

        if (isRequiredNumber) {
            if (!password.matches(".*\\d.*")) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("A senha deve conter pelo menos um dígito").addConstraintViolation();
                return false;
            }
        }

        if (isRequiredLetter) {
            if (!password.matches(".*[A-Za-zÀ-ÖØ-öø-ÿ].*")) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("A senha deve conter pelo menos uma letra").addConstraintViolation();
                return false;
            }
        }

        if (isRequiredSymbol) {
            if (!password.matches("/.*[!@#$%^&*()\\-+=|{}\\[\\]/:;<>,.?~].*/")) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("A senha deve conter pelo menos um caractere especial ($*&@#)").addConstraintViolation();
                return false;
            }
        }

        return true;
    }
}
