package com.santho.personaldiary.validators;

import com.santho.personaldiary.annotations.Password;
import com.santho.personaldiary.helpers.ArrayToStringHelper;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class PasswordValidator implements ConstraintValidator<Password, char[]>{
    private int spl, caps, minLength, maxLength;
    @Override
    public void initialize(Password constraintAnnotation) {
        this.spl = constraintAnnotation.spl();
        this.caps = constraintAnnotation.caps();
        this.minLength = constraintAnnotation.minLength();
        this.maxLength = constraintAnnotation.maxLength();
    }

    @Override
    public boolean isValid(char[] chars, ConstraintValidatorContext constraintValidatorContext) {
        String special = Pattern.quote("@!#$%^&*().,[]{}'\";:/?><`~+-*/");
        String password = ArrayToStringHelper.arrToString(chars);
        String regexPattern = String.format(
                "^(?=.*[a-z])(?=.*[A-Z]{%d,})(?=.*[0-9])(?=.*[%s]{%d,})[A-Za-z0-9%s]{%d,%d}$",
                this.caps, special, this.spl, special, this.minLength, this.maxLength
        );
        Pattern pattern = Pattern.compile(regexPattern);

        return pattern.matcher(password).matches();
    }
}
