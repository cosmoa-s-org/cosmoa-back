package com.kumoh.cosmoa.dto.request;

import com.kumoh.cosmoa.dto.ComposeDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseComposeRequestDTO {
    private List<ComposeDTO> composeList;
}
