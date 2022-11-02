package com.kumoh.cosmoa.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlaceDTO {
    private int id;
    private int userId;
    private String name;
    private String address;
    private String lat;
    private String lng;
    private String imgPath;
    private String description;
    private String createdDate;
    private String modifiedDate;
}
