package com.jr.learningmanagementsystem.dto;

import com.jr.learningmanagementsystem.dto.validation.CourseDateValidation;
import java.time.LocalDate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@SuperBuilder(toBuilder = true)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Getter
@CourseDateValidation
public class CourseDto {

  @NotBlank(message = "Name cannot be empty.")
  String name;

  @NotNull(message = "Date of birth cannot be empty.")
  @DateTimeFormat(iso = ISO.DATE)
  LocalDate startDate;

  LocalDate endDate;

}
