package com.jr.learningmanagementsystem.services;

import com.jr.learningmanagementsystem.dto.StudentLogDto;
import com.jr.learningmanagementsystem.exceptions.LogNotFoundException;
import com.jr.learningmanagementsystem.mapper.StudentLogMapper;
import com.jr.learningmanagementsystem.model.Student;
import com.jr.learningmanagementsystem.model.StudentLog;
import com.jr.learningmanagementsystem.repositories.StudentLogRepository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class StudentLogServiceTest {

  private StudentLogService studentLogService;

  @Mock
  private StudentLogRepository studentLogRepository;

  @Mock
  private StudentService studentService;

  @Mock
  private StudentLogMapper studentLogMapper;

  @Before
  public void setUp() {
    studentLogService = new StudentLogService(studentLogRepository, studentService, studentLogMapper);
  }

  @Test
  public void testLogHours_Success() {
    // Prepare test data
    Long studentId = 1L;
    StudentLogDto studentLogDto = StudentLogDto.builder().build();

    Student student = new Student();
    student.setId(studentId);

    StudentLog studentLog = new StudentLog();
    studentLog.setStudent(student);

    Mockito.when(studentService.findById(studentId)).thenReturn(student);
    Mockito.when(studentLogMapper.createStudentLogFromDto(studentLogDto)).thenReturn(studentLog);
    Mockito.when(studentLogRepository.save(studentLog)).thenReturn(studentLog);
    Mockito.when(studentLogMapper.studentLogDtoFromStudentLog(studentLog)).thenReturn(studentLogDto);

    StudentLogDto result = studentLogService.logHours(studentId, studentLogDto);

    Assertions.assertThat(result).isEqualTo(studentLogDto);
  }

  @Test(expected = LogNotFoundException.class)
  public void testUpdateLog_LogNotFound() {
    Long logId = 1L;
    StudentLogDto updatedLogDto = StudentLogDto.builder().build();

    Mockito.when(studentLogRepository.findById(logId)).thenReturn(Optional.empty());

    studentLogService.updateLog(logId, updatedLogDto);
  }

  @Test
  public void testUpdateLog_Success() {
    Long logId = 1L;
    StudentLogDto updatedLogDto = StudentLogDto.builder().taskDescription("Updated Description").build();

    StudentLog existingLog = new StudentLog();

    Mockito.when(studentLogRepository.findById(logId)).thenReturn(Optional.of(existingLog));
    existingLog.setTaskDescription(updatedLogDto.getTaskDescription());
    Mockito.when(studentLogRepository.save(existingLog)).thenReturn(existingLog);
    Mockito.when(studentLogMapper.studentLogDtoFromStudentLog(existingLog)).thenReturn(updatedLogDto);

    StudentLogDto result = studentLogService.updateLog(logId, updatedLogDto);

    Assertions.assertThat(result.getTaskDescription())
        .isNotEmpty()
        .isEqualTo(updatedLogDto.getTaskDescription());
    Mockito.verify(studentLogMapper).updateStudentLogFromDto(updatedLogDto, existingLog);
  }

  @Test
  public void testDeleteLog_Success() {
    Long logId = 1L;

    studentLogService.deleteLog(logId);

    Mockito.verify(studentLogRepository).deleteById(logId);
  }
}

