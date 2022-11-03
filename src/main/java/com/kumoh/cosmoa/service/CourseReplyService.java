package com.kumoh.cosmoa.service;

import com.kumoh.cosmoa.dto.CourseReplyDTO;
import com.kumoh.cosmoa.mapper.CourseReplyMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseReplyService {
    private final CourseReplyMapper courseReplyMapper;

    @Autowired
    public CourseReplyService(CourseReplyMapper courseReplyMapper) {
        this.courseReplyMapper = courseReplyMapper;
    }

    public List<CourseReplyDTO> findAll() {
        return courseReplyMapper.getCourseReplyList();
    }
    
    public int createCourseReply(CourseReplyDTO courseReplyDto) {
    	return courseReplyMapper.createCourseReply(courseReplyDto);
    }
    
    public int deleteCourseReply(int id) {
    	return courseReplyMapper.deleteCourseReply(id);
    }
    
    public int updateCourseReply(CourseReplyDTO courseReplyDto) {
    	return courseReplyMapper.updateCourseReply(courseReplyDto);
    }
}