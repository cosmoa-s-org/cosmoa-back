package com.kumoh.cosmoa.mapper;

import com.kumoh.cosmoa.dto.CourseReportDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseReportMapper {

    List<CourseReportDTO> getCourseReportList();
    int createCourseReport(CourseReportDTO courseReportDto);
    int deleteCourseReport(int id);
    int updateCourseReport(CourseReportDTO courseReportDto);
}
