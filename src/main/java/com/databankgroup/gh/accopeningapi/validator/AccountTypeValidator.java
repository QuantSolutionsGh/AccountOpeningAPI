package com.databankgroup.gh.accopeningapi.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class AccountTypeValidator implements ConstraintValidator<AccountType, String> {

   private List<String> validAccountTypes = new ArrayList<String>();
   public void initialize(AccountType constraint) {

      validAccountTypes.add("Individual");
      validAccountTypes.add("Joint");
   }

   public boolean isValid(String obj, ConstraintValidatorContext context) {

     return validAccountTypes.contains(obj);
   }


}
