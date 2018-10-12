package com.databankgroup.gh.accopeningapi.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SecondApplicantDetailsValidator.class)
public @interface SecondApplicantDetailsCheck {
    String message() default "Requires either Mr , Mrs, Prof, Dr, Miss";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String first();
    String second();

    @Target({TYPE,ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List
    {
        SecondApplicantDetailsCheck[] value();
    }





}
