package com.kumoh.cosmoa.mapper;

import com.kumoh.cosmoa.dto.CourseReplyDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CourseReplyMapper {

    List<CourseReplyDTO> getCourseReplyList();
    List<CourseReplyDTO> getCourseReplyListByCourseId(@Param("courseId") int courseId);
    int createCourseReply(CourseReplyDTO courseReplyDto);
    int deleteCourseReply(int id);
    int updateCourseReply(CourseReplyDTO courseReplyDto);
}
