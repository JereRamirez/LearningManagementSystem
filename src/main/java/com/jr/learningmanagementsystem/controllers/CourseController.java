package com.jr.learningmanagementsystem.controllers;

import com.jr.learningmanagementsystem.dto.CourseDto;
import com.jr.learningmanagementsystem.services.CourseService;
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
@RequestMapping("/api/courses")
@Validated
public class CourseController {
  private final CourseService courseService;

  @PreAuthorize("hasRole('ADMIN')")
  @PostMapping()
  @ResponseStatus(HttpStatus.CREATED)
  public CourseDto createCourse(@RequestBody CourseDto course) {
    return courseService.createCourse(course);
  }
}
