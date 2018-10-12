package com.databankgroup.gh.accopeningapi.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AccountTypeValidator implements ConstraintValidator<AccountType, String> {
   public void initialize(AccountType constraint) {
   }

   public boolean isValid(String obj, ConstraintValidatorContext context) {

      if (obj == null || (!obj.contains("Individual")) || (!obj.contains("Joint")))

      return false; else return true;
   }


}
