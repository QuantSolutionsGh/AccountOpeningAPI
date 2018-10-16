package com.databankgroup.gh.accopeningapi.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class PhotoIDValidator implements ConstraintValidator<PhotoIDCheck, String> {

   private List<String> validPhotoIDs = new ArrayList<String>();
   public void initialize(PhotoIDCheck constraint) {
     validPhotoIDs.add("Passport");
     validPhotoIDs.add("Voter's ID");
     validPhotoIDs.add("NHIS");
     validPhotoIDs.add("National ID");
     validPhotoIDs.add("Driver's license");
     validPhotoIDs.add("");
     validPhotoIDs.add(null);
   }

   public boolean isValid(String obj, ConstraintValidatorContext context) {


      return validPhotoIDs.contains(obj);



   }
}
