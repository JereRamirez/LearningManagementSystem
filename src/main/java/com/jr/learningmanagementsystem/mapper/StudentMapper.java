package com.jr.learningmanagementsystem.mapper;

import com.jr.learningmanagementsystem.dto.StudentDto;
import com.jr.learningmanagementsystem.model.Student;
import com.jr.learningmanagementsystem.model.enums.Gender;
import org.mapstruct.Mapper;

@Mapper(config = CommonMapperConfig.class)
public interface StudentMapper {

  Student createStudentFromDto(StudentDto studentDto);
  StudentDto studentDtoFromStudent(Student student);

  default Gender toGender(String gender) {
    if (gender == null) {
      return null;
    }
    return Gender.fromString(gender);
  }

  default String toGenderString(Gender gender){
    if (gender == null) {
      return null;
    }
    return gender.name();
  }

}
