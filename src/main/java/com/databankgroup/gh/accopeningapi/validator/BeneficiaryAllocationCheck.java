package com.databankgroup.gh.accopeningapi.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = BeneficiaryAllocationValidator.class)
public @interface BeneficiaryAllocationCheck {
    String message() default "Total allocation for all beneficiaries (benAllocation1," +
            "benAllocation2,benAllocation3) should be 100%";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
