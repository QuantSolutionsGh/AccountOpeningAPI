package com.databankgroup.gh.accopeningapi.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class MaritalStatusValidator implements ConstraintValidator<MaritalStatusCheck, String> {
   private List<String> validItems = new ArrayList<String>();
   public void initialize(MaritalStatusCheck constraint) {
      validItems.add("");
      validItems.add("Single");
      validItems.add("Married");
      validItems.add("Divorced");
      validItems.add(null);
   }

   public boolean isValid(String obj, ConstraintValidatorContext context) {

      return validItems.contains(obj);
   }
}
