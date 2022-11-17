package com.kumoh.cosmoa.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Slf4j
public class FileUtils {
    public static String saveImage(String dir, String id, MultipartFile image) {
        /*
         * 1번째 파라미터 : 파일을 저장할 디렉토리명
         * 2번째 파라미터 : 파일의 이름, System.currentTimeMillis() 값을 더해 파일 이름 정함
         * 3번째 파라미터 : Multipartfile image
         * */
        if (image == null) return null;
        try {
            String os = System.getProperty("os.name").toLowerCase();
            File imageDirectory = null;
            if (os.contains("windows")) {
                imageDirectory = new File("C:\\workspace\\images\\" + dir);
            } else if (os.contains("linux")) {
                imageDirectory = new File("/dev/sda/" + dir);
            } else {
                throw new RuntimeException("saveImage method in " + os + " not supported.");
            }

            // 디렉토리가 존재하지 않는다면 새로 만들기
            if (!imageDirectory.exists()) {
                imageDirectory.mkdirs();
                log.info("mkdir {}", imageDirectory.getAbsolutePath());
            }

            StringBuilder sb = new StringBuilder();
            sb.append(imageDirectory.getAbsolutePath());
            sb.append("\\");
            sb.append(id);
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
