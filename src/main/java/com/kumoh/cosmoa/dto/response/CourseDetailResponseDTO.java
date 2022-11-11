package com.kumoh.cosmoa.dto.response;

import com.kumoh.cosmoa.dto.CourseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseDetailResponseDTO {
    private CourseDTO course;
    private String nickname;
    private int like;
    private int isLike;
}
