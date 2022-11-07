package com.kumoh.cosmoa.mapper;

import com.kumoh.cosmoa.dto.ComposeDTO;
import com.kumoh.cosmoa.dto.ComposeResponseDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CourseComposeMapper {
    List<ComposeResponseDTO> findByCourseId(@Param("courseId") int courseId);

    int insertCompose(@Param("param") ComposeDTO dto);

    int updateCompose(@Param("param") ComposeDTO dto);

    int deleteCompose(@Param("composeId") int composeId);
}
