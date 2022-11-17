package com.kumoh.cosmoa.dto.response;

import com.kumoh.cosmoa.dto.PlaceDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlaceDetailResponseDTO {
    private PlaceDTO place;
    private byte[] image;
    private String nickname;
    private int like;
    private int isLike;

    public void loadImage() {
        try {
            if (this.place.getImgPath() == null) return;
            Path path = Paths.get(this.place.getImgPath());
            byte[] bytes = Files.readAllBytes(path);
            this.image = bytes;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
