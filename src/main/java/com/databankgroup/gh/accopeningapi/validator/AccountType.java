package com.databankgroup.gh.accopeningapi.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AccountTypeValidator.class)
public @interface AccountType {
    String message() default "Should be either Individual or Joint";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
