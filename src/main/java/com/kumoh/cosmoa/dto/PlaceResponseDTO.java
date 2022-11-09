package com.kumoh.cosmoa.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlaceResponseDTO {
    private int id;
    private int userId;
    private String name;
    private String address;
    private String lat;
    private String lng;
    private byte[] image;
    private String description;
    private String createdDate;
    private String modifiedDate;

    public PlaceResponseDTO(PlaceDTO dto) {
        this.id = dto.getId();
        this.userId = dto.getUserId();
        this.name = dto.getName();
        this.address = dto.getAddress();
        this.lat = dto.getLat();
        this.lng = dto.getLng();
        this.description = dto.getDescription();
        this.createdDate = dto.getCreatedDate();
        this.modifiedDate = dto.getModifiedDate();

        try {
            if (dto.getImgPath() == null) return;
            Path path = Paths.get(dto.getImgPath());
            byte[] bytes = Files.readAllBytes(path);
//            File file = new File(dto.getImgPath());
//            FileItem fileItem = new DiskFileItemFactory().createItem("file",
//                    Files.probeContentType(file.toPath()), false, file.getName());
            this.image = bytes;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
