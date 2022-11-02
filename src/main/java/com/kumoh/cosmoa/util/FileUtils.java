package com.kumoh.cosmoa.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Slf4j
public class FileUtils {
    public static String saveImage(int userId, MultipartFile image) {
        try {
            File imageDirectory = new File("C:\\workspace\\images");
            // 디렉토리가 존재하지 않는다면 새로 만들기
            if (!imageDirectory.exists()) {
                imageDirectory.mkdir();
                log.info("mkdir {}", imageDirectory.getAbsolutePath());
            }

            StringBuilder sb = new StringBuilder();
            sb.append(imageDirectory.getAbsolutePath());
            sb.append("\\");
            sb.append(userId);
            sb.append("_");
            sb.append(System.currentTimeMillis());
            sb.append(".png");
            String path = sb.toString();

            image.transferTo(new File(path));
            log.info("saved in {}.", path);

            return path;
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void deleteImage(String path) {
        if (path == null || path.equals("")) {
            return;
        }

        File file = new File(path);
        if (file.exists() && !file.delete()) {
            throw new RuntimeException("Image delete failed.");
        }
    }
}
