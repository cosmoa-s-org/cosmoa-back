package com.kumoh.cosmoa.mapper;

import com.kumoh.cosmoa.dto.CourseDTO;
import com.kumoh.cosmoa.dto.CourseDetailResponseDTO;
import com.kumoh.cosmoa.dto.CourseResponseDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CourseMapper {

    List<CourseDTO> getCourseList();
    List<CourseResponseDTO> getCourseResponseList();
    CourseDetailResponseDTO getCourseDetail(@Param("courseId") int courseId,
                                            @Param("userId") int userId);
    int createCourse(CourseDTO courseDto);
    int deleteCourse(int id);
    int updateCourse(CourseDTO courseDto);
}
