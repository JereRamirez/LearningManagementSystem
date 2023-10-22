package com.jr.learningmanagementsystem.mapper;

import com.jr.learningmanagementsystem.dto.CourseDto;
import com.jr.learningmanagementsystem.model.Course;
import java.time.LocalDate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(config = CommonMapperConfig.class)
public interface CourseMapper {

  @Mapping( target = "endDate", source = ".", qualifiedByName = "CalculateEndDate")
  Course createCourseFromDto(CourseDto courseDto);

  CourseDto courseDtoFromCourse(Course course);

  @Named("CalculateEndDate")
  default LocalDate calculateEndDate(CourseDto courseDto) {
    if (courseDto.getEndDate() == null) {
      return courseDto.getStartDate().plusMonths(6);
    }
    return courseDto.getEndDate();
  }
}
