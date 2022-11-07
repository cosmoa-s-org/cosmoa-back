package com.kumoh.cosmoa.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseComposeResponseDTO {
    private int id;
    private int costTime;
    private int sequence;
    private PlaceResponseDTO place;

    public CourseComposeResponseDTO(ComposeResponseDTO dto) {
        this.id = dto.getId();
        this.costTime = dto.getCostTime();
        this.sequence = dto.getSequence();
        this.place = new PlaceResponseDTO(dto.getPlace());
    }
}
