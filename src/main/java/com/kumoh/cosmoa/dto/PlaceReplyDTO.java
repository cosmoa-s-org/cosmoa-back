package com.kumoh.cosmoa.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlaceReplyDTO {
    private int id;
    private int placeId;
    private int userId;
    private String comment;
    private String imgPath;
    private String createdDate;
    private String modifiedDate;
}
