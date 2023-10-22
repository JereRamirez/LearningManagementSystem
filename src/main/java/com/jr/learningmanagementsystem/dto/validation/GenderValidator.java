package com.jr.learningmanagementsystem.dto.validation;

import com.jr.learningmanagementsystem.dto.StudentDto;
import com.jr.learningmanagementsystem.model.enums.Gender;
import java.util.Objects;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class GenderValidator implements ConstraintValidator<BirthDateValidation, StudentDto> {
  @Override
  public void initialize(BirthDateValidation constraintAnnotation) {
  }

  @Override
  public boolean isValid(StudentDto studentDto, ConstraintValidatorContext context) {
    return Objects.isNull(studentDto.getGender())
    || Gender.isValid(studentDto.getGender());
  }
}
