package com.santho.personaldiary.validators;

import com.santho.personaldiary.annotations.DiaryDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
public class DateValidator implements ConstraintValidator<DiaryDate, LocalDate> {

    @Override
    public boolean isValid(LocalDate localDate, ConstraintValidatorContext constraintValidatorContext) {
        if(localDate == null)   return false;
        LocalDate today = LocalDate.now();
        return localDate.isBefore(today.plusDays(1)) && localDate.isAfter(today.minusDays(7));
    }
}
