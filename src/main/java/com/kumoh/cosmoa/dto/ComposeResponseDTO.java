package com.kumoh.cosmoa.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ComposeResponseDTO {
    private int id;
    private int costTime;
    private int sequence;
    private PlaceDTO place;
}
