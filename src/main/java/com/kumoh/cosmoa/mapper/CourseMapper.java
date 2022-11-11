package com.kumoh.cosmoa.mapper;

import com.kumoh.cosmoa.dto.CourseDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseMapper {

    List<CourseDTO> getCourseList();
    int createCourse(CourseDTO courseDto);
    int deleteCourse(int id);
    int updateCourse(CourseDTO courseDto);
}
