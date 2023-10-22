package com.jr.learningmanagementsystem.model;

import com.jr.learningmanagementsystem.model.enums.TaskCategory;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class StudentLog {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  private Student student;

  private LocalDate logDate;

  @Enumerated(EnumType.STRING)
  private TaskCategory taskCategory;

  private String taskDescription;

  private LocalDateTime timeSpent;
}

