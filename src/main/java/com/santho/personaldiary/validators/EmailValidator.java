package com.santho.personaldiary.validators;

import com.santho.personaldiary.annotations.Email;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator implements ConstraintValidator<Email, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        Pattern pat = Pattern.compile("^[\\w]+@([\\w]+.)+[a-z]{2,4}$");
        Matcher mat = pat.matcher(s);
        return mat.matches();
    }
}
