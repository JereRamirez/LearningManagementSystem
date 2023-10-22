package com.jr.learningmanagementsystem.controllers;

import com.jr.learningmanagementsystem.services.StudentCourseEnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/enrollments")
public class StudentCourseEnrollmentController {
  private final StudentCourseEnrollmentService enrollmentService;

  @PostMapping("/enroll")
  @ResponseStatus(HttpStatus.CREATED)
  public void enrollStudentInCourse(@RequestParam Long studentId, @RequestParam Long courseId) {
    enrollmentService.enrollStudentInCourse(studentId, courseId);
  }
}
