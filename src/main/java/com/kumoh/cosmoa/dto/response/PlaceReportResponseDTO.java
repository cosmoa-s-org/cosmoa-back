package com.kumoh.cosmoa.dto.response;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.kumoh.cosmoa.dto.PlaceDTO;
import com.kumoh.cosmoa.dto.PlaceReportUserDTO;
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
    private PlaceDTO place;
    private UserDTO user;
    private List<PlaceReportUserDTO> placeReportUserList;
    private byte[] image;
    private int placeId;
    
    public void loadImage() {
        try {
            if (place.getImgPath() == null) return;
            Path path = Paths.get(place.getImgPath());
            byte[] bytes = Files.readAllBytes(path);
            this.image = bytes;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
