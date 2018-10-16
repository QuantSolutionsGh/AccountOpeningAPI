package com.databankgroup.gh.accopeningapi.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class GenderValidator implements ConstraintValidator<GenderCheck, String> {
   private List<String> validItems = new ArrayList<String>();
   public void initialize(GenderCheck constraint) {

      validItems.add("Male");
      validItems.add("Female");
      /*
      So that I can add annonation to gender of 2nd applicant even if accounttype is Individual.
      The trick here is that the gender1 will have both @NotNull and @GenderCheck
      Whiles gender2 will have @GenderCheck and the @NotNull applied on the class when the
      accounttype is Joint
       */
      validItems.add("");
      validItems.add(null);
   }

   public boolean isValid(String obj, ConstraintValidatorContext context) {

      return validItems.contains(obj);
   }
}
