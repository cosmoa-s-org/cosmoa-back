package com.kumoh.cosmoa.mapper;

import com.kumoh.cosmoa.dto.CourseReplyDTO;
import com.kumoh.cosmoa.dto.response.CourseReplyResponseDTO;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CourseReplyMapper {

    List<CourseReplyDTO> getCourseReplyList();
    List<CourseReplyResponseDTO> getCourseReplyListByCourseId(@Param("courseId") int courseId);
    int createCourseReply(@Param("param") CourseReplyDTO courseReplyDto);
    int deleteCourseReply(int id);
    int updateCourseReply(@Param("param") CourseReplyDTO courseReplyDto);
}
