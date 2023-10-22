package com.jr.learningmanagementsystem.model.enums;

public enum Gender {
  MALE("Male"),
  FEMALE("Female"),
  OTHER("Other"),
  PREFER_NOT_TO_SAY("Prefer Not to Say");

  private final String label;

  Gender(String label) {
    this.label = label;
  }

  public static boolean isValid(String gender) {
    try {
      Gender.valueOf(gender);
      return true;
    } catch (IllegalArgumentException ex) {
      return false;
    }
  }

  public String getLabel() {
    return label;
  }
  public static Gender fromString(String text) {
    for (Gender gender : Gender.values()) {
      if (gender.label.equalsIgnoreCase(text)) {
        return gender;
      }
    }
    throw new IllegalArgumentException("Invalid gender: " + text);
  }
}
