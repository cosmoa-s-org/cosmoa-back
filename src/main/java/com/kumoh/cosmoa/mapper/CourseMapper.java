package com.kumoh.cosmoa.mapper;

import com.kumoh.cosmoa.dto.CourseDTO;
import com.kumoh.cosmoa.dto.response.CourseDetailResponseDTO;
import com.kumoh.cosmoa.dto.response.CourseLocationResponseDTO;
import com.kumoh.cosmoa.dto.response.CourseResponseDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CourseMapper {

    List<CourseLocationResponseDTO> getCourseList();
    List<CourseResponseDTO> getCourseResponseList();
    List<CourseResponseDTO> getHotCourseResponseList();
    List<CourseLocationResponseDTO> getScrapedCourseResponseList(@Param("userId") int userId);
    List<CourseLocationResponseDTO> getPostedCourseResponseList(@Param("userId") int userId);
    List<CourseResponseDTO> searchByLatLng(@Param("lat") String lat,
                                           @Param("lng") String lng);
    List<CourseLocationResponseDTO> getCourseByLatlng(@Param("lat") String lat,
            @Param("lng") String lng);
    CourseDetailResponseDTO getCourseDetail(@Param("courseId") int courseId,
                                            @Param("userId") int userId);
    int createCourse(CourseDTO courseDto);
    int deleteCourse(int id);
    int updateCourse(CourseDTO courseDto);
}
