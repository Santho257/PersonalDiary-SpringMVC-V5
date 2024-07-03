package com.santho.personaldiary.validators;

import com.santho.personaldiary.annotations.PasswordMatches;
import com.santho.personaldiary.dto.Passwordable;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class PasswordMatchValidator implements ConstraintValidator<PasswordMatches, Passwordable> {

    @Override
    public boolean isValid(Passwordable passwordable, ConstraintValidatorContext constraintValidatorContext) {
        String password = Arrays.toString(passwordable.getPassword());
        String rePassword = Arrays.toString(passwordable.getRePassword());
        return password.equals(rePassword);
    }
}
