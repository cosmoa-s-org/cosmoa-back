package com.kumoh.cosmoa.dto.response;

import com.kumoh.cosmoa.dto.PlaceDTO;
import com.kumoh.cosmoa.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlaceReportResponseDTO {
    private int id;
    private PlaceDTO place;
    private UserDTO user;
    private int type;
}
