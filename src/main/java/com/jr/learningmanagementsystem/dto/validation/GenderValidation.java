package com.jr.learningmanagementsystem.dto.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = GenderValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface GenderValidation {
  String message() default "Please provide a valid gender.";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

}
