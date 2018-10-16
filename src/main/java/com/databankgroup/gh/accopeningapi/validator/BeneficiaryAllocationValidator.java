package com.databankgroup.gh.accopeningapi.validator;

import com.databankgroup.gh.accopeningapi.model.AppBean;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class BeneficiaryAllocationValidator implements ConstraintValidator<BeneficiaryAllocationCheck, AppBean> {

   private String message;
   public void initialize(BeneficiaryAllocationCheck constraint) {

      message= constraint.message();
   }

   public boolean isValid(AppBean appBean, ConstraintValidatorContext context) {

      boolean valid= (appBean.getBen1Allocation() + appBean.getBen2Allocation() +
              appBean.getBen3Allocation()==100);
      if (!valid){
         context.buildConstraintViolationWithTemplate(message)
                 .addPropertyNode("ben1Allocation")
                 .addConstraintViolation()
                 .disableDefaultConstraintViolation();
         context.buildConstraintViolationWithTemplate(message)
                 .addPropertyNode("ben2Allocation")
                 .addConstraintViolation()
                 .disableDefaultConstraintViolation();
         context.buildConstraintViolationWithTemplate(message)
                 .addPropertyNode("ben3Allocation")
                 .addConstraintViolation()
                 .disableDefaultConstraintViolation();
      }

      return valid;

   }
}
