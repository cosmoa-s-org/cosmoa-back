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

    public List<CourseLikeDTO> findAll() {
        return courseLikeMapper.getCourseLikeList();
    }
    
    public int createCourseLike(CourseLikeDTO courseLikeDto) {
    	return courseLikeMapper.createCourseLike(courseLikeDto);
    }
    
    public int deleteCourseLike(int id) {
    	return courseLikeMapper.deleteCourseLike(id);
    }
    
    public int updateCourseLike(CourseLikeDTO courseLikeDto) {
    	return courseLikeMapper.updateCourseLike(courseLikeDto);
    }
}