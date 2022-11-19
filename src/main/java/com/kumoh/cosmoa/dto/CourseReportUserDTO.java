package com.kumoh.cosmoa.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseReportUserDTO {
    private int id;
    private int courseId;
    private int userId;
    private int type;
    private int state;
    private String nickname;
    private String email;
}
