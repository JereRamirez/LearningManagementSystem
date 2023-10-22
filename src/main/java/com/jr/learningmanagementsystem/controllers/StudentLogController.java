package com.jr.learningmanagementsystem.controllers;

import com.jr.learningmanagementsystem.dto.StudentLogDto;
import com.jr.learningmanagementsystem.services.StudentLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/students")
@Validated
public class StudentLogController {
  private final StudentLogService studentLogService;

  @PostMapping("/{studentId}/logs")
  @ResponseStatus(HttpStatus.CREATED)
  public StudentLogDto logHours(@PathVariable Long studentId, @RequestBody StudentLogDto studentLogDto) {
    return studentLogService.logHours(studentId, studentLogDto);
  }

  @PutMapping("/logs/{logId}")
  @ResponseStatus(HttpStatus.OK)
  public StudentLogDto updateLog(@PathVariable Long logId, @RequestBody StudentLogDto updatedLogDto) {
    return studentLogService.updateLog(logId, updatedLogDto);
  }

  @DeleteMapping("/logs/{logId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteLog(@PathVariable Long logId) {
    studentLogService.deleteLog(logId);

  }
}
