package com.jr.learningmanagementsystem.repositories;

import com.jr.learningmanagementsystem.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
  boolean existsByName(String name);
}
