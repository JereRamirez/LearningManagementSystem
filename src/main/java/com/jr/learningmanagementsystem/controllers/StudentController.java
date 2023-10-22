package com.jr.learningmanagementsystem.controllers;

import com.jr.learningmanagementsystem.dto.StudentDto;
import com.jr.learningmanagementsystem.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/students")
@Validated
public class StudentController {
  private final StudentService studentService;

  @PreAuthorize("isAuthenticated()")
  @PostMapping("/register")
  @ResponseStatus(HttpStatus.CREATED)
  public StudentDto registerStudent(@RequestBody StudentDto student) {
    return studentService.registerStudent(student);
  }
}
