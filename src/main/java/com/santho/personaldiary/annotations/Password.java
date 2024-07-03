package com.santho.personaldiary.annotations;

import com.santho.personaldiary.validators.PasswordValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PasswordValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Password {
    public String message() default "Password must contain: \n{spl} special characters,\n{caps} Capital Letters,\nLength between {minLength} - {maxLength}";
    public int spl() default 0;
    public int caps() default 0;
    public int minLength() default 1;
    public int maxLength() default 255;

    public Class<?>[] groups() default {};
    public Class<? extends Payload>[] payload() default {};
}
