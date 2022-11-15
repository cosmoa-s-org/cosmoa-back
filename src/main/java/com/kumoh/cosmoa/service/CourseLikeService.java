package com.kumoh.cosmoa.service;

import com.kumoh.cosmoa.dto.CourseLikeDTO;
import com.kumoh.cosmoa.mapper.CourseLikeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseLikeService {
    private final CourseLikeMapper courseLikeMapper;

    @Autowired
    public CourseLikeService(CourseLikeMapper courseLikeMapper) {
        this.courseLikeMapper = courseLikeMapper;
    }
    
    public int existsByCourseIdAndUserId(CourseLikeDTO dto) {
    	return courseLikeMapper.existsByCourseIdAndUserId(dto);
    }
    
    public int countByCourseId(int courseId) {
    	return courseLikeMapper.countByCourseId(courseId);
    }
    
    public int createCourseLike(CourseLikeDTO dto) {
    	return courseLikeMapper.createCourseLike(dto);
    }
    
    public int deleteCourseLike(CourseLikeDTO dto) {
    	return courseLikeMapper.deleteCourseLike(dto);
    }
    
}