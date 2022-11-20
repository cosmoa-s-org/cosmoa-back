package com.kumoh.cosmoa.service;

import com.kumoh.cosmoa.dto.CourseDTO;
import com.kumoh.cosmoa.dto.response.CourseDetailResponseDTO;
import com.kumoh.cosmoa.dto.response.CourseResponseDTO;
import com.kumoh.cosmoa.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private final CourseMapper courseMapper;

    @Autowired
    public CourseService(CourseMapper courseMapper) {
        this.courseMapper = courseMapper;
    }

    public List<CourseDTO> findAll() {
        return courseMapper.getCourseList();
    }

    public List<CourseResponseDTO> findCourseResponseList() {
        return courseMapper.getCourseResponseList();
    }
    
    public List<CourseResponseDTO> findHotCourseResponseList() {
    	return courseMapper.getHotCourseResponseList();
    }

    public List<CourseResponseDTO> searchByLatLng(String lat, String lng) {
        return courseMapper.searchByLatLng(lat, lng);
    }
    public CourseDetailResponseDTO findCourseDetail(int courseId, int userId) {
        return courseMapper.getCourseDetail(courseId, userId);
    }

    
    public int createCourse(CourseDTO courseDto) {
        courseMapper.createCourse(courseDto);
    	return courseDto.getId();
    }
    
    public int deleteCourse(int id) {
    	return courseMapper.deleteCourse(id);
    }
    
    public int updateCourse(CourseDTO courseDto) {
    	return courseMapper.updateCourse(courseDto);
    }


}