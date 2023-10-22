package com.jr.learningmanagementsystem.mapper;

import com.jr.learningmanagementsystem.dto.StudentLogDto;
import com.jr.learningmanagementsystem.model.StudentLog;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(config = CommonMapperConfig.class, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StudentLogMapper {

  StudentLog createStudentLogFromDto(StudentLogDto studentLogDto);
  StudentLogDto studentLogDtoFromStudentLog(StudentLog studentLog);

  void updateStudentLogFromDto(StudentLogDto studentLogDto,
      @MappingTarget StudentLog studentLog);

}
