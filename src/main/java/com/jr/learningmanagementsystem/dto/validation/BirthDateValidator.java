package com.jr.learningmanagementsystem.dto.validation;

import com.jr.learningmanagementsystem.dto.StudentDto;
import java.time.LocalDate;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class BirthDateValidator implements ConstraintValidator<BirthDateValidation, StudentDto> {
  @Override
  public void initialize(BirthDateValidation constraintAnnotation) {
  }

  @Override
  public boolean isValid(StudentDto studentDto, ConstraintValidatorContext context) {
    return studentDto.getDateOfBirth().isBefore(LocalDate.now().minusYears(16));
  }
}
