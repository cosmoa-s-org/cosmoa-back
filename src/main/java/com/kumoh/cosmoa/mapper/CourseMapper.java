package com.kumoh.cosmoa.mapper;

import com.kumoh.cosmoa.dto.CourseDTO;
import com.kumoh.cosmoa.dto.response.CourseDetailResponseDTO;
import com.kumoh.cosmoa.dto.response.CourseResponseDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CourseMapper {

    List<CourseDTO> getCourseList();
    List<CourseResponseDTO> getCourseResponseList();
    List<CourseResponseDTO> getHotCourseResponseList(); 
    CourseDetailResponseDTO getCourseDetail(@Param("courseId") int courseId,
                                            @Param("userId") int userId);
    int createCourse(CourseDTO courseDto);
    int deleteCourse(int id);
    int updateCourse(CourseDTO courseDto);
}
