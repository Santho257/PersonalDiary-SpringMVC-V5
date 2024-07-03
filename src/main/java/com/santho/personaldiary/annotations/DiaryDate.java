package com.santho.personaldiary.annotations;

import com.santho.personaldiary.validators.DateValidator;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = DateValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DiaryDate {
    public String message() default "You Can Only Choose between past one week";

    public Class<?>[] groups() default {};
    public Class<? extends Payload>[] payload() default {};
}