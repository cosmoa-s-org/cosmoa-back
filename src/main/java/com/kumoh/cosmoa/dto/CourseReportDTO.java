package com.kumoh.cosmoa.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseReportDTO {
    private int id;
    private int userId;
    private int courseId;
    private int type;
}
