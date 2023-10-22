package com.jr.learningmanagementsystem.services;

import com.jr.learningmanagementsystem.model.Course;
import com.jr.learningmanagementsystem.model.Student;
import com.jr.learningmanagementsystem.model.StudentCourseEnrollment;
import com.jr.learningmanagementsystem.repositories.CourseRepository;
import com.jr.learningmanagementsystem.repositories.StudentCourseEnrollmentRepository;
import com.jr.learningmanagementsystem.repositories.StudentRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class StudentCourseEnrollmentServiceTest {

  private StudentCourseEnrollmentService enrollmentService;

  @Mock
  private StudentCourseEnrollmentRepository enrollmentRepository;

  @Mock
  private CourseRepository courseRepository;

  @Mock
  private StudentRepository studentRepository;

  @Before
  public void setUp() {
    enrollmentService = new StudentCourseEnrollmentService(enrollmentRepository, courseRepository, studentRepository);
  }

  @Test
  @Transactional
  public void testEnrollStudentInCourse_Success() {
    Long studentId = 1L;
    Long courseId = 2L;

    Student student = new Student();
    student.setId(studentId);

    Course course = new Course();
    course.setId(courseId);

    StudentCourseEnrollment enrollment = new StudentCourseEnrollment();
    enrollment.setStudent(student);
    enrollment.setCourse(course);

    Mockito.when(studentRepository.findById(studentId)).thenReturn(Optional.of(student));
    Mockito.when(courseRepository.findById(courseId)).thenReturn(Optional.of(course));
    Mockito.when(enrollmentRepository.countByStudentId(studentId)).thenReturn(2L);
    Mockito.when(enrollmentRepository.existsByStudentIdAndCourseId(studentId, courseId)).thenReturn(false);
    Mockito.when(enrollmentRepository.save(enrollment)).thenReturn(enrollment);

    // Perform the test
    StudentCourseEnrollment result = enrollmentService.enrollStudentInCourse(
        studentId, courseId);

    Assertions.assertThat(result).isEqualTo(enrollment);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testEnrollStudentInCourse_StudentNotFound() {
    Long studentId = 1L;
    Long courseId = 2L;

    Mockito.when(studentRepository.findById(studentId)).thenReturn(Optional.empty());

    enrollmentService.enrollStudentInCourse(studentId, courseId);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testEnrollStudentInCourse_CourseNotFound() {
    Long studentId = 1L;
    Long courseId = 2L;

    Student student = new Student();
    student.setId(studentId);

    Mockito.when(studentRepository.findById(studentId)).thenReturn(Optional.of(student));
    Mockito.when(courseRepository.findById(courseId)).thenReturn(Optional.empty());

    enrollmentService.enrollStudentInCourse(studentId, courseId);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testEnrollStudentInCourse_MaxEnrollmentReached() {
    Long studentId = 1L;
    Long courseId = 2L;

    Student student = new Student();
    student.setId(studentId);

    Course course = new Course();
    course.setId(courseId);

    Mockito.when(studentRepository.findById(studentId)).thenReturn(Optional.of(student));
    Mockito.when(courseRepository.findById(courseId)).thenReturn(Optional.of(course));
    Mockito.when(enrollmentRepository.countByStudentId(studentId)).thenReturn(3L);

    // This should throw IllegalArgumentException for reaching the maximum enrollment limit
    enrollmentService.enrollStudentInCourse(studentId, courseId);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testEnrollStudentInCourse_AlreadyEnrolled() {
    Long studentId = 1L;
    Long courseId = 2L;

    Student student = new Student();
    student.setId(studentId);

    Course course = new Course();
    course.setId(courseId);

    Mockito.when(studentRepository.findById(studentId)).thenReturn(Optional.of(student));
    Mockito.when(courseRepository.findById(courseId)).thenReturn(Optional.of(course));
    Mockito.when(enrollmentRepository.countByStudentId(studentId)).thenReturn(2L);
    Mockito.when(enrollmentRepository.existsByStudentIdAndCourseId(studentId, courseId)).thenReturn(true);

    enrollmentService.enrollStudentInCourse(studentId, courseId);
  }
}

