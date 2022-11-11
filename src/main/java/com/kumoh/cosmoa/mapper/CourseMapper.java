package com.kumoh.cosmoa.mapper;

import com.kumoh.cosmoa.dto.CourseDTO;
import com.kumoh.cosmoa.dto.CourseResponseDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseMapper {

    List<CourseDTO> getCourseList();
    List<CourseResponseDTO> getCourseResponseList();
    int createCourse(CourseDTO courseDto);
    int deleteCourse(int id);
    int updateCourse(CourseDTO courseDto);
}
