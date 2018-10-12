package com.databankgroup.gh.accopeningapi.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TitleValidator implements ConstraintValidator<TitleCheck, String> {
   public void initialize(TitleCheck constraint) {
   }

   public boolean isValid(String obj, ConstraintValidatorContext context) {


      if (obj == null || (!obj.contains("Mr")) || (!obj.contains("Miss")) || (!obj.contains("Mrs")) || (!obj.contains("Dr")) || (!obj.contains("Prof")))

         return false; else return true;
   }
}
