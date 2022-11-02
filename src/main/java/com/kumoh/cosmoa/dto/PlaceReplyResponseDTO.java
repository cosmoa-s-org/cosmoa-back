package com.kumoh.cosmoa.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlaceReplyResponseDTO {
    private int id;
    private int placeId;
    private int userId;
    private String comment;
    private byte[] img;
    private String createdDate;
    private String modifiedDate;

    public PlaceReplyResponseDTO(PlaceReplyDTO dto) {
        this.id = dto.getId();
        this.placeId = dto.getPlaceId();
        this.userId = dto.getUserId();
        this.comment = dto.getComment();
        this.createdDate = dto.getCreatedDate();
        this.modifiedDate = dto.getModifiedDate();

        try {
            Path path = Paths.get(dto.getImgPath());
            this.img = Files.readAllBytes(path);
        } catch (Exception e) {
            throw new RuntimeException("Image loading failed.");
        }
    }
}
