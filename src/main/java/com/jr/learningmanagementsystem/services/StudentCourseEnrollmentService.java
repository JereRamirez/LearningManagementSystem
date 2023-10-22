package com.jr.learningmanagementsystem.services;

import com.jr.learningmanagementsystem.model.Course;
import com.jr.learningmanagementsystem.model.Student;
import com.jr.learningmanagementsystem.model.StudentCourseEnrollment;
import com.jr.learningmanagementsystem.repositories.CourseRepository;
import com.jr.learningmanagementsystem.repositories.StudentCourseEnrollmentRepository;
import com.jr.learningmanagementsystem.repositories.StudentRepository;
import javax.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentCourseEnrollmentService {
  StudentCourseEnrollmentRepository enrollmentRepository;
  CourseRepository courseRepository;
  StudentRepository studentRepository;

  @Transactional
  public StudentCourseEnrollment enrollStudentInCourse(Long studentId, Long courseId) {
    Student student = studentRepository.findById(studentId)
        .orElseThrow(() -> new IllegalArgumentException("Student not found"));

    Course course = courseRepository.findById(courseId)
        .orElseThrow(() -> new IllegalArgumentException("Course not found"));

    if (enrollmentRepository.countByStudentId(studentId) >= 3) {
      throw new IllegalArgumentException("Student has already reached the maximum enrollment limit.");
    }

    if (enrollmentRepository.existsByStudentIdAndCourseId(studentId, courseId)) {
      throw new IllegalArgumentException("Student is already enrolled in this course.");
    }

    StudentCourseEnrollment enrollment = new StudentCourseEnrollment();
    enrollment.setStudent(student);
    enrollment.setCourse(course);

    return enrollmentRepository.save(enrollment);
  }
}
