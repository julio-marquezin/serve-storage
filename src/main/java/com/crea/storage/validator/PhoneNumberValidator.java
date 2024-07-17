package com.crea.storage.validator;

import com.crea.storage.exception.PhoneNumberValidationException;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {

    private static PhoneNumberUtil phoneUtil;

    @Override
    public void initialize(PhoneNumber constraintAnnotation) {
        phoneUtil = PhoneNumberUtil.getInstance();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try {
            return phoneUtil.isValidNumber(phoneUtil.parse(value, "Brazil"));
        } catch (NumberParseException e) {
            throw new PhoneNumberValidationException("Invalid phone number", e);
        }
    }

}
