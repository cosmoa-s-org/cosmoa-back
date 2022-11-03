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
    private int user_id;
    private int course_id;
    private String comment;
    private Date created_date;
    private Date modified_date;
}
