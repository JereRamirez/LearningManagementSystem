package com.jr.learningmanagementsystem.services;

import com.jr.learningmanagementsystem.dto.CourseDto;
import com.jr.learningmanagementsystem.exceptions.DuplicateCourseException;
import com.jr.learningmanagementsystem.mapper.CourseMapper;
import com.jr.learningmanagementsystem.model.Course;
import com.jr.learningmanagementsystem.repositories.CourseRepository;
import javax.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@Validated
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CourseService {
  CourseRepository courseRepository;
  CourseMapper courseMapper;

  public CourseDto createCourse(@Valid CourseDto courseDto) {
    Course course = courseMapper.createCourseFromDto(courseDto);

    if (courseRepository.existsByName(course.getName())) {
      throw new DuplicateCourseException("Course name already exists.");
    }

    return courseMapper.courseDtoFromCourse(courseRepository.save(course));
  }
}