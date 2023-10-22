package com.jr.learningmanagementsystem.services;

import com.jr.learningmanagementsystem.dto.StudentDto;
import com.jr.learningmanagementsystem.exceptions.DuplicateEmailException;
import com.jr.learningmanagementsystem.mapper.StudentMapper;
import com.jr.learningmanagementsystem.model.Student;
import com.jr.learningmanagementsystem.repositories.StudentRepository;
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
public class StudentService {
  StudentRepository studentRepository;
  StudentMapper studentMapper;

  public StudentDto registerStudent(@Valid StudentDto studentDto) {
    Student student = studentMapper.createStudentFromDto(studentDto);

    if (studentRepository.existsByEmail(student.getEmail())) {
      throw new DuplicateEmailException("Email address already registered.");
    }

    return studentMapper.studentDtoFromStudent(studentRepository.save(student));
  }

  public Student findById(Long id) {
    return studentRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Student not found."));
  }
}