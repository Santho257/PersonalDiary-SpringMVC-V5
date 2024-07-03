package com.santho.personaldiary.annotations;

import com.santho.personaldiary.validators.PasswordMatchValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PasswordMatchValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordMatches {
    public String message() default "Password doesn't match";

    public Class<?>[] groups() default {};
    public Class<? extends Payload>[] payload() default {};
}
