package com.kumoh.cosmoa.mapper;

import com.kumoh.cosmoa.dto.CourseLikeDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CourseLikeMapper {

    int countByCourseId(@Param("courseId") int courseId);
    int existsByCourseIdAndUserId(@Param("param") CourseLikeDTO dto);
    int createCourseLike(@Param("param") CourseLikeDTO dto);
    int deleteCourseLike(@Param("likeId") int likeId);
}
