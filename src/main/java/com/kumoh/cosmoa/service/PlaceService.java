package com.kumoh.cosmoa.service;

import com.kumoh.cosmoa.dto.PlaceDTO;
import com.kumoh.cosmoa.dto.PlaceResponseDTO;
import com.kumoh.cosmoa.mapper.PlaceMapper;
import com.kumoh.cosmoa.util.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PlaceService {
    private final PlaceMapper placeMapper;

    public PlaceService(PlaceMapper placeMapper) {
        this.placeMapper = placeMapper;
    }

    public PlaceResponseDTO insert(PlaceDTO dto, MultipartFile img) {
        String path = FileUtils.saveImage("C:\\workspace\\images\\place", String.valueOf(dto.getUserId()), img);
        dto.setImgPath(path);

        if (placeMapper.insertPlace(dto) == 0) throw new RuntimeException("Insert Place failed. try again.");

        return null;
    }

    public PlaceResponseDTO update(PlaceDTO dto, MultipartFile img) {
        dto.setImgPath(placeMapper.getPlace(dto.getId()).getImgPath());

        if (img != null) {
            FileUtils.deleteImage(dto.getImgPath());
            String path = FileUtils.saveImage("C:\\workspace\\images\\place", String.valueOf(dto.getUserId()), img);
            dto.setImgPath(path);
        }

        if (placeMapper.updatePlace(dto) == 0) throw new RuntimeException("Update Place failed. try again.");

        return null;
    }

    public boolean delete(int id) {
        PlaceDTO dto = placeMapper.getPlace(id);
        FileUtils.deleteImage(dto.getImgPath());

        if (placeMapper.deletePlace(dto) == 0) throw new RuntimeException("Delete failed. try again.");

        return true;
    }

    public List<PlaceResponseDTO> findAll() {
        List<PlaceDTO> dtos = placeMapper.getPlaceList();
        log.info("dtos.get(0) : {}", dtos.get(0));

        //byte[] image = dto.getImgPath().;

        return dtos.stream().map(PlaceResponseDTO::new).collect(Collectors.toList());
    }

    public List<PlaceResponseDTO> findByNameAndAddress(String search) {
        List<PlaceDTO> dtos = placeMapper.findByNameAndAddress(search);

        return dtos.stream().map(PlaceResponseDTO::new).collect(Collectors.toList());
    }
}
