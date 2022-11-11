package com.kumoh.cosmoa.dto.request;

import com.kumoh.cosmoa.dto.ComposeDTO;
import com.kumoh.cosmoa.dto.CourseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseRequestDTO {
    private CourseDTO course;
    private List<ComposeDTO> compose;
}
