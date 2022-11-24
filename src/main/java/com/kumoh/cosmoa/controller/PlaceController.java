package com.kumoh.cosmoa.controller;

import com.kumoh.cosmoa.dto.PlaceDTO;
import com.kumoh.cosmoa.dto.response.PlaceDetailResponseDTO;
import com.kumoh.cosmoa.dto.response.PlaceResponseDTO;
import com.kumoh.cosmoa.dto.response.PlaceTableResponseDTO;
import com.kumoh.cosmoa.dto.ResponseDTO;
import com.kumoh.cosmoa.service.PlaceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
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

    @PostMapping(value = "", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> create(@RequestParam("name") String name,
                                    @RequestParam("description") String description,
                                    @RequestParam("address") String address,
                                    @RequestParam("lat") String lat,
                                    @RequestParam("lng") String lng,
                                    @RequestParam("userId") int userId,
                                    @RequestParam(value = "img", required = false) MultipartFile img) {
        try {
            log.info("img : {}", img != null);
            PlaceDTO dto = PlaceDTO.builder()
                    .name(name)
                    .description(description)
                    .address(address)
                    .lat(lat)
                    .lng(lng)
                    .userId(userId)
                    .build();
            placeService.insert(dto, img);
            return ResponseEntity.ok().body(dto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseDTO.builder().error(e.getMessage()).build());
        }
    }

    @PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> update(@PathVariable int id,
                                    @RequestParam("name") String name,
                                    @RequestParam("description") String description,
                                    @RequestParam("address") String address,
                                    @RequestParam("lat") String lat,
                                    @RequestParam("lng") String lng,
                                    @RequestParam(value = "img", required = false) MultipartFile img) {
        log.info("img: {}", img != null);
        try {
            PlaceDTO dto = PlaceDTO.builder()
                    .id(id)
                    .name(name)
                    .description(description)
                    .address(address)
                    .lat(lat)
                    .lng(lng)
                    .build();
            placeService.update(dto, img);
            return ResponseEntity.ok().body(dto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseDTO.builder().error(e.getMessage()).build());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {

        try {
            placeService.delete(id);
            return ResponseEntity.ok().body(id);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseDTO.builder().error(e.getMessage()).build());
        }
    }

    @GetMapping("")
    public ResponseEntity<?> searchByNameAndAddress(@RequestParam("search") String search) {
        /*
         * GET http://localhost:8080/place?search="구미시"
         */

        try {
            List<PlaceResponseDTO> dtos = placeService.findByNameAndAddress(search);
            ResponseDTO<List<PlaceResponseDTO>> response =
                    ResponseDTO.<List<PlaceResponseDTO>>builder()
                            .data(dtos)
                            .build();

            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseDTO.builder().error(e.getMessage()).build());
        }
    }

    @GetMapping("/detail")
    public ResponseEntity<?> searchByPlaceId(@RequestParam("placeId") int placeId,
                                             @RequestParam("userId") int userId) {
        try {
            PlaceDetailResponseDTO dto = placeService.findByPlaceId(placeId, userId);
            ResponseDTO<PlaceDetailResponseDTO> response =
                    ResponseDTO.<PlaceDetailResponseDTO>builder()
                            .data(dto)
                            .build();
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseDTO.builder().error(e.getMessage()).build());
        }
    }
    
    @GetMapping("/scraped-place")
    public ResponseEntity<?> getScrapedPlaceList(@RequestParam("userId") int userId) {
        try {
            List<PlaceTableResponseDTO> dto = placeService.findScrapedPlaceResponseList(userId);
            ResponseDTO<List<PlaceTableResponseDTO>> response =
                    ResponseDTO.<List<PlaceTableResponseDTO>>builder()
                            .data(dto)
                            .build();
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseDTO.builder().error(e.getMessage()).build());
        }
    }
    
    @GetMapping("/posted-place")
    public ResponseEntity<?> getPostedPlaceList(@RequestParam("userId") int userId) {
        try {
            List<PlaceTableResponseDTO> dto = placeService.findPostedPlaceResponseList(userId);
            ResponseDTO<List<PlaceTableResponseDTO>> response =
                    ResponseDTO.<List<PlaceTableResponseDTO>>builder()
                            .data(dto)
                            .build();
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseDTO.builder().error(e.getMessage()).build());
        }
    }

    @GetMapping(value = "/download", produces = "image/png")
    public ResponseEntity<?> download() {
        PlaceResponseDTO dto = placeService.findAll().get(0);
        return ResponseEntity.ok().body(dto.getImage());
    }
}
