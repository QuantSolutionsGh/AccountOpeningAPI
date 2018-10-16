package com.databankgroup.gh.accopeningapi.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PhotoIDValidator.class)
public @interface PhotoIDCheck {
    String message() default "Should be either Passport, Voter's ID, NHIS, National ID, Driver's license";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
