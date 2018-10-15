package com.databankgroup.gh.accopeningapi.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class TitleValidator implements ConstraintValidator<TitleCheck, String> {

   private List<String> validTitles = new ArrayList<String>();
   public void initialize(TitleCheck constraint) {
      validTitles.add("Mr");
      validTitles.add("Miss");
      validTitles.add("Mrs");
      validTitles.add("Dr");
      validTitles.add("Prof");
   }

   public boolean isValid(String obj, ConstraintValidatorContext context) {


      return validTitles.contains(obj);



   }
}
