package com.databankgroup.gh.accopeningapi.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TitleValidator.class)
public @interface TitleCheck {
    String message() default "Requires either Mr , Mrs, Prof, Dr, Miss";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
