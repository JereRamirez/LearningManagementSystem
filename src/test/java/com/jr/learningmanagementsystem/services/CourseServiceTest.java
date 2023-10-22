package com.jr.learningmanagementsystem.services;

import com.jr.learningmanagementsystem.dto.CourseDto;
import com.jr.learningmanagementsystem.exceptions.DuplicateCourseException;
import com.jr.learningmanagementsystem.mapper.CourseMapper;
import com.jr.learningmanagementsystem.model.Course;
import com.jr.learningmanagementsystem.repositories.CourseRepository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CourseServiceTest {

  private CourseService courseService;

  @Mock
  private CourseRepository courseRepository;

  @Mock
  private CourseMapper courseMapper;


  @Before
  public void setUp() {
    courseService = new CourseService(courseRepository, courseMapper);
  }

  @Test
  public void testCreateCourse_Success() {
    CourseDto courseDto = CourseDto.builder().name("Test Course").build();

    Course course = new Course();
    course.setId(1L);
    course.setName(courseDto.getName());

    Mockito.when(courseMapper.createCourseFromDto(courseDto)).thenReturn(course);
    Mockito.when(courseRepository.existsByName(course.getName())).thenReturn(false);
    Mockito.when(courseRepository.save(course)).thenReturn(course);
    Mockito.when(courseMapper.courseDtoFromCourse(course)).thenReturn(courseDto);

    CourseDto result = courseService.createCourse(courseDto);

    Assertions.assertThat(result)
        .isNotNull()
        .isEqualTo(courseDto);
  }

  @Test(expected = DuplicateCourseException.class)
  public void testCreateCourse_DuplicateCourse() {
    CourseDto courseDto = CourseDto.builder().name("Duplicate Course").build();

    Course course = new Course();
    course.setId(1L);
    course.setName(courseDto.getName());

    Mockito.when(courseMapper.createCourseFromDto(courseDto)).thenReturn(course);
    Mockito.when(courseRepository.existsByName(course.getName())).thenReturn(true);

    courseService.createCourse(courseDto);
  }
}
