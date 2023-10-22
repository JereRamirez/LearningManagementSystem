package com.jr.learningmanagementsystem.repositories;

import com.jr.learningmanagementsystem.model.StudentCourseEnrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCourseEnrollmentRepository extends JpaRepository<StudentCourseEnrollment, Long> {
  boolean existsByStudentIdAndCourseId(Long studentId, Long courseId);

  long countByStudentId(Long studentId);
}
