package com.jr.learningmanagementsystem.services;

import com.jr.learningmanagementsystem.dto.StudentLogDto;
import com.jr.learningmanagementsystem.exceptions.LogNotFoundException;
import com.jr.learningmanagementsystem.mapper.StudentLogMapper;
import com.jr.learningmanagementsystem.model.StudentLog;
import com.jr.learningmanagementsystem.repositories.StudentLogRepository;
import javax.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentLogService {
  StudentLogRepository studentLogRepository;
  StudentService studentService;
  StudentLogMapper studentLogMapper;

  public StudentLogDto logHours(Long studentId, @Valid StudentLogDto studentLogDto) {
    StudentLog studentLog = studentLogMapper.createStudentLogFromDto(studentLogDto);
    studentLog.setStudent(studentService.findById(studentId));
    return studentLogMapper.studentLogDtoFromStudentLog(studentLogRepository.save(studentLog));
  }

  public StudentLogDto updateLog(Long logId, StudentLogDto updatedLogDto) {
    StudentLog existingLog = studentLogRepository.findById(logId)
        .orElseThrow(() -> new LogNotFoundException("Log not found"));

    studentLogMapper.updateStudentLogFromDto(updatedLogDto, existingLog);
    return studentLogMapper.studentLogDtoFromStudentLog(studentLogRepository.save(existingLog));
  }

  public void deleteLog(Long logId) {
    studentLogRepository.deleteById(logId);
  }
}

