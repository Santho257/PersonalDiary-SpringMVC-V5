package com.santho.personaldiary.annotations;

import com.santho.personaldiary.validators.EmailValidator;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = EmailValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Email {
    public String message() default "Email should contain one '@' and atleast a '.' after '@'";

    public Class<?>[] groups() default {};
    public Class<? extends Payload>[] payload() default {};
}
