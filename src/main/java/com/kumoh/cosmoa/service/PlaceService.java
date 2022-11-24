package com.kumoh.cosmoa.service;

import com.kumoh.cosmoa.dto.PlaceDTO;
import com.kumoh.cosmoa.dto.response.PlaceDetailResponseDTO;
import com.kumoh.cosmoa.dto.response.PlaceResponseDTO;
import com.kumoh.cosmoa.dto.response.PlaceTableResponseDTO;
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
        String path = FileUtils.saveImage("place", String.valueOf(dto.getUserId()), img);
        dto.setImgPath(path);

        if (placeMapper.insertPlace(dto) == 0) throw new RuntimeException("Insert Place failed. try again.");

        return null;
    }

    public PlaceResponseDTO update(PlaceDTO dto, MultipartFile img) {
        dto.setImgPath(placeMapper.getPlace(dto.getId()).getImgPath());

        if (img != null) {
            FileUtils.deleteImage(dto.getImgPath());
            String path = FileUtils.saveImage("place", String.valueOf(dto.getUserId()), img);
            dto.setImgPath(path);
        }

        if (placeMapper.updatePlace(dto) == 0) throw new RuntimeException("Update Place failed. try again.");

        return null;
    }
    
    public List<PlaceTableResponseDTO> findScrapedPlaceResponseList(int userId) {
    	List<PlaceTableResponseDTO> dtos = placeMapper.getScrapedPlaceResponseList(userId);
    	
    	return dtos;
    }
    
    public List<PlaceTableResponseDTO> findPostedPlaceResponseList(int userId) {
    	List<PlaceTableResponseDTO> dtos = placeMapper.getPostedPlaceResponseList(userId);
    	
    	return dtos;
    }

    public boolean delete(int id) {
        PlaceDTO dto = placeMapper.getPlace(id);
        FileUtils.deleteImage(dto.getImgPath());

        PlaceDTO deleted = PlaceDTO.builder()
                .id(id)
                .name("유저의 요청으로 삭제된 장소")
                .description("유저의 요청으로 삭제된 장소입니다.")
                .lat("0")
                .lng("0")
                .address("유저의 요청으로 삭제된 장소")
                .build();

        if (placeMapper.updatePlace(deleted) == 0) throw new RuntimeException("Delete failed. try again.");

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

    public PlaceDetailResponseDTO findByPlaceId(int placeId, int userId) {
        PlaceDetailResponseDTO dto = placeMapper.findByPlaceId(placeId, userId);
        dto.loadImage();

        return dto;
    }
}
