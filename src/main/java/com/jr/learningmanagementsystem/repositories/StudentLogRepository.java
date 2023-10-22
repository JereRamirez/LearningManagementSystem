package com.jr.learningmanagementsystem.repositories;

import com.jr.learningmanagementsystem.model.StudentLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentLogRepository extends JpaRepository<StudentLog, Long> {

}
