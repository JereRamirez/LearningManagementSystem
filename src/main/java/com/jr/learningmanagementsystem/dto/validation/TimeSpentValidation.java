package com.jr.learningmanagementsystem.dto.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = TimeSpentValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface TimeSpentValidation {
  String message() default "Time spent has to be 30mins increment/decrement.";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

}
