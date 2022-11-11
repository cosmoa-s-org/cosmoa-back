package com.kumoh.cosmoa.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseReplyDTO {
    private int id;
    private int userId;
    private int courseId;
    private String comment;
    private String createdDate;
    private String modifiedDate;
}
