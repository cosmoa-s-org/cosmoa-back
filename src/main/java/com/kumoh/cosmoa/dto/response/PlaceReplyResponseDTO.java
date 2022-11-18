package com.kumoh.cosmoa.dto.response;

import com.kumoh.cosmoa.dto.PlaceReplyDTO;
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
    private String nickname;
	private int id;
    private int userId;
    private String comment;
    private byte[] img;
    private String createdDate;
    private String modifiedDate;
    private String imgPath;

    public PlaceReplyResponseDTO(PlaceReplyResponseDTO dto) {
        this.id = dto.getId();
        this.userId = dto.getUserId();
        this.nickname = dto.getNickname();
        this.comment = dto.getComment();
        this.createdDate = dto.getCreatedDate();
        this.modifiedDate = dto.getModifiedDate();

        try {
            if (dto.getImgPath() == null) return;
            Path path = Paths.get(dto.getImgPath());
            this.img = Files.readAllBytes(path);
        } catch (Exception e) {
            throw new RuntimeException("Image loading failed.");
        }
    }
}
