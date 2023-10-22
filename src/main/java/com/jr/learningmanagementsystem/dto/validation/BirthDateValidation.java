package com.jr.learningmanagementsystem.dto.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = BirthDateValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface BirthDateValidation {
  String message() default "Student shall be at least 16 years old.";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

}
