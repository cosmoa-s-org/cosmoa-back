package com.kumoh.cosmoa.mapper;

import com.kumoh.cosmoa.dto.CourseLikeDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseLikeMapper {

    List<CourseLikeDTO> getCourseLikeList();
    int createCourseLike(CourseLikeDTO courseLikeDto);
    int deleteCourseLike(int id);
    int updateCourseLike(CourseLikeDTO courseLikeDto);
}
