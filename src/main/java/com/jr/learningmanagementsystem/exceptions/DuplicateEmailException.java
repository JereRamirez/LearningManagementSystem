package com.jr.learningmanagementsystem.exceptions;

public class DuplicateEmailException extends
    RuntimeException {

  public DuplicateEmailException(String message) {
    super(message);
  }
}
