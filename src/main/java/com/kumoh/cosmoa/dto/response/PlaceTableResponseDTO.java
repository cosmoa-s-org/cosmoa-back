package com.kumoh.cosmoa.dto.response;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlaceTableResponseDTO {
		private int id;
	    private String name;
	    private int like;
	    private String nickname;
	    private int replyCount;
	    private String imgPath;
	    private String description;
	    private byte[] image;
	    
	    public void loadImage() {
	        try {
	            if (getImgPath() == null) return;
	            Path path = Paths.get(getImgPath());
	            byte[] bytes = Files.readAllBytes(path);
	            this.image = bytes;
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	    }
}
