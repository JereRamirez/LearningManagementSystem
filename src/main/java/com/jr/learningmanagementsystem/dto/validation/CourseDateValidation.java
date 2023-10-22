package com.jr.learningmanagementsystem.dto.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = CourseDateValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseDateValidation {
  String message() default "Start date must be a future date.";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

}
