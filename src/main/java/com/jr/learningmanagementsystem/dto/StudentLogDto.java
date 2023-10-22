package com.jr.learningmanagementsystem.dto;

import com.jr.learningmanagementsystem.dto.validation.TimeSpentValidation;
import com.jr.learningmanagementsystem.model.enums.TaskCategory;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
@TimeSpentValidation
public class StudentLogDto {

  @NotNull(message = "Date cannot be empty.")
  @DateTimeFormat(iso = ISO.DATE)
  LocalDate date;
  @NotBlank(message = "Task category cannot be empty.")
  TaskCategory taskCategory;

  @NotBlank(message = "Task description cannot be empty.")
  String taskDescription;


  @NotBlank(message = "Time Spent cannot be empty.")
  LocalDateTime timeSpent;
}
