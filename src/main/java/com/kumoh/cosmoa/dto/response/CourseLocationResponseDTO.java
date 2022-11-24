package com.kumoh.cosmoa.dto.response;

import java.util.List;

import com.kumoh.cosmoa.dto.CourseLocationDTO;
import com.kumoh.cosmoa.dto.LatlngDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseLocationResponseDTO {
	private int id;
    private CourseLocationDTO course;
    private List<LatlngDTO> latlng;
}
