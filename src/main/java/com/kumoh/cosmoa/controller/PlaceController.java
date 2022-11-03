package com.kumoh.cosmoa.controller;

import com.kumoh.cosmoa.dto.PlaceDTO;
import com.kumoh.cosmoa.dto.PlaceResponseDTO;
import com.kumoh.cosmoa.dto.ResponseDTO;
import com.kumoh.cosmoa.service.PlaceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/place")
@Slf4j
public class PlaceController {
    private final PlaceService placeService;

    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @PostMapping("")
    public ResponseEntity<?> create(PlaceDTO dto,
                                    MultipartFile img) {
        try {
            placeService.insert(dto, img);
            return ResponseEntity.ok().body(dto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id,
                                    PlaceDTO dto,
                                    MultipartFile img) {
        log.info("img: {}", img != null);
        try {
            dto.setId(id);
            placeService.update(dto, img);
            return ResponseEntity.ok().body(dto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {

        try {
            placeService.delete(id);
            return ResponseEntity.ok().body(id);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // 전체 목록 조회, 검색 구현 필요
    @GetMapping("")
    public ResponseEntity<?> read() {
        List<PlaceResponseDTO> dtos = placeService.findAll();
        ResponseDTO<List<PlaceResponseDTO>> response =
                ResponseDTO.<List<PlaceResponseDTO>>builder()
                        .data(dtos)
                        .build();

        return ResponseEntity.ok().body(response);
    }

    @GetMapping(value = "/download", produces = "image/png")
    public ResponseEntity<?> download() {
        PlaceResponseDTO dto = placeService.findAll().get(0);
        return ResponseEntity.ok().body(dto.getImage());
    }
}