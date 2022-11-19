package com.kumoh.cosmoa.dto.response;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.kumoh.cosmoa.dto.CourseDTO;
import com.kumoh.cosmoa.dto.CourseReportUserDTO;
import com.kumoh.cosmoa.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseReportResponseDTO {
    private CourseDTO course;
    private UserDTO user;
    private List<CourseReportUserDTO> courseReportUserList;
    private int courseId;
    
}
