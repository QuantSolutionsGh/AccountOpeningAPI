package com.databankgroup.gh.accopeningapi.validator;




import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SecondApplicantDetailsValidator implements ConstraintValidator<SecondApplicantDetailsCheck, Object> {

   private String firstFieldName;
   private String secondFieldName;
   private String message;

   public void initialize(SecondApplicantDetailsCheck constraint) {
      firstFieldName = constraint.first();
      secondFieldName = constraint.second();
      message=constraint.message();
   }

   //obj is the appbean
   public boolean isValid(Object obj, ConstraintValidatorContext context) {
      boolean valid = true;

      try {
         final String accountType = BeanUtils.getProperty(obj,firstFieldName);  //get account type value
         final String field2 = BeanUtils.getProperty(obj,secondFieldName); //get 2nd application field to check null

         if ((accountType.contains("Joint")) && (field2==null)){
            valid=false;
         }



      } catch (Exception ignore) {

      }

      if (!valid){
         context.buildConstraintViolationWithTemplate(message)
                 .addPropertyNode(secondFieldName)
                 .addConstraintViolation()
                 .disableDefaultConstraintViolation();
      }


      return valid;
   }
}
