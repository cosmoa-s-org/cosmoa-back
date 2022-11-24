package com.kumoh.cosmoa.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseLocationDTO {
	private String name;
    private int like;
    private int replyCount;
    private String description;
}
