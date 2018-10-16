package com.databankgroup.gh.accopeningapi.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MaritalStatusValidator.class)
public @interface MaritalStatusCheck {
    String message() default "Should be either Single / Married / Divorced ";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
