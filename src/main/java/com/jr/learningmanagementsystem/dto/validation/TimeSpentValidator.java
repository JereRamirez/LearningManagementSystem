package com.jr.learningmanagementsystem.dto.validation;

import com.jr.learningmanagementsystem.dto.StudentLogDto;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TimeSpentValidator implements ConstraintValidator<TimeSpentValidation, StudentLogDto> {
  @Override
  public void initialize(TimeSpentValidation constraintAnnotation) {
  }

  @Override
  public boolean isValid(StudentLogDto studentLogDto, ConstraintValidatorContext context) {
    int minutes = studentLogDto.getTimeSpent().getMinute();
    int seconds = studentLogDto.getTimeSpent().getSecond();
    return seconds == 00
        && (minutes == 00 || minutes == 30);
  }
}
