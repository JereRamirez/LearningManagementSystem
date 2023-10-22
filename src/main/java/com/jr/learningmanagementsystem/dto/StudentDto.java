package com.jr.learningmanagementsystem.dto;

import com.jr.learningmanagementsystem.dto.validation.BirthDateValidation;
import com.jr.learningmanagementsystem.dto.validation.GenderValidation;
import java.time.LocalDate;
import javax.validation.constraints.Email;
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
@BirthDateValidation
@GenderValidation
public class StudentDto {

  @NotBlank(message = "First Name cannot be empty.")
  String firstName;

  @NotBlank(message = "Last Name cannot be empty.")
  String lastName;

  @NotNull(message = "Date of birth cannot be empty.")
  @DateTimeFormat(iso = ISO.DATE)
  LocalDate dateOfBirth;

  @NotBlank(message = "Address cannot be empty.")
  String address;

  @Email(regexp = ".+@.+\\..+",message = "Invalid email provided.")
  String email;

  @NotBlank(message = "Phone number cannot be empty.")
  String phoneNumber;

  String gender;
}
