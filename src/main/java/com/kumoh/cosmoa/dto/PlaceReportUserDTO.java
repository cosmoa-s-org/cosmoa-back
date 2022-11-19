package com.kumoh.cosmoa.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlaceReportUserDTO {
    private int id;
    private int placeId;
    private int userId;
    private int type;
    private int state;
    private String email;
    private String nickname;
}
