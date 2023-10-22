package com.jr.learningmanagementsystem.dto.validation;

import com.jr.learningmanagementsystem.dto.CourseDto;
import java.time.LocalDate;
import java.util.Objects;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseDateValidator implements ConstraintValidator<CourseDateValidation, CourseDto> {
  @Override
  public void initialize(CourseDateValidation constraintAnnotation) {
  }

  @Override
  public boolean isValid(CourseDto courseDto, ConstraintValidatorContext context) {
    if (courseDto.getStartDate().isBefore(LocalDate.now()))
      return false;

    return Objects.isNull(courseDto.getEndDate())
        || courseDto.getEndDate().isBefore(courseDto.getStartDate().plusMonths(6));
  }
}
