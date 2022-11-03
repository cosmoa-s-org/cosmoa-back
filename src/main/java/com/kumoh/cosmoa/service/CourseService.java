package com.kumoh.cosmoa.service;

import com.kumoh.cosmoa.dto.CourseDTO;
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
        return courseMapper.getUserList();
    }
    
    public int createCourse(CourseDTO courseDto) {
    	return courseMapper.createCourse(courseDto);
    }
    
    public int deleteCourse(int id) {
    	return courseMapper.deleteCourse(id);
    }
    
    public int updateCourse(CourseDTO courseDto) {
    	return courseMapper.updateCourse(courseDto);
    }
}