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
public class CourseDTO {
    private int id;
    private String name;
    private String description;
    private String created_date;
    private String modified_date;
    private int userId;
}
