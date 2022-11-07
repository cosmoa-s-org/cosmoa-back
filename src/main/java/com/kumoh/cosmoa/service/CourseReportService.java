package com.kumoh.cosmoa.service;

import com.kumoh.cosmoa.dto.CourseReportDTO;
import com.kumoh.cosmoa.mapper.CourseReportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseReportService {
    private final CourseReportMapper courseReportMapper;

    @Autowired
    public CourseReportService(CourseReportMapper courseReportMapper) {
        this.courseReportMapper = courseReportMapper;
    }

    public List<CourseReportDTO> findAll() {
        return courseReportMapper.getCourseReportList();
    }
    
    public int createCourseReport(CourseReportDTO courseReportDto) {
    	return courseReportMapper.createCourseReport(courseReportDto);
    }
    
    public int deleteCourseReport(int id) {
    	return courseReportMapper.deleteCourseReport(id);
    }
    
    public int updateCourseReport(CourseReportDTO courseReportDto) {
    	return courseReportMapper.updateCourseReport(courseReportDto);
    }
}