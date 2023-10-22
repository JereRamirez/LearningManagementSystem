package com.jr.learningmanagementsystem.services;

import com.jr.learningmanagementsystem.dto.StudentDto;
import com.jr.learningmanagementsystem.exceptions.DuplicateEmailException;
import com.jr.learningmanagementsystem.mapper.StudentMapper;
import com.jr.learningmanagementsystem.model.Student;
import com.jr.learningmanagementsystem.repositories.StudentRepository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class StudentServiceTest {

  private StudentService studentService;

  @Mock
  private StudentRepository studentRepository;

  @Mock
  private StudentMapper studentMapper;

  @Before
  public void setUp() {
    studentService = new StudentService(studentRepository, studentMapper);
  }

  @Test
  public void testRegisterStudent_Success() {
    StudentDto studentDto = StudentDto.builder().build();

    Student student = new Student();

    Mockito.when(studentMapper.createStudentFromDto(studentDto)).thenReturn(student);
    Mockito.when(studentRepository.existsByEmail(student.getEmail())).thenReturn(false);
    Mockito.when(studentRepository.save(student)).thenReturn(student);
    Mockito.when(studentMapper.studentDtoFromStudent(student)).thenReturn(studentDto);

    StudentDto result = studentService.registerStudent(studentDto);

    Assertions.assertThat(result)
        .isNotNull()
        .isEqualTo(studentDto);
  }

  @Test(expected = DuplicateEmailException.class)
  public void testRegisterStudent_DuplicateEmail() {
    // Prepare test data
    StudentDto studentDto = StudentDto.builder().build();

    Student student = new Student();

    Mockito.when(studentMapper.createStudentFromDto(studentDto)).thenReturn(student);
    Mockito.when(studentRepository.existsByEmail(student.getEmail())).thenReturn(true);

    studentService.registerStudent(studentDto);
  }

  @Test
  public void testFindById_Success() {
    Long studentId = 1L;
    Student student = new Student();

    Mockito.when(studentRepository.findById(studentId)).thenReturn(Optional.of(student));

    Student result = studentService.findById(studentId);

    Assertions.assertThat(result)
        .isNotNull()
        .isEqualTo(student);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testFindById_StudentNotFound() {
    Long studentId = 1L;

    Mockito.when(studentRepository.findById(studentId)).thenReturn(Optional.empty());

    studentService.findById(studentId);
  }
}
