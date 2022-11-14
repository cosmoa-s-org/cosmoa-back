package com.kumoh.cosmoa.controller;

import com.kumoh.cosmoa.dto.PlaceLikeDTO;
import com.kumoh.cosmoa.dto.ResponseDTO;
import com.kumoh.cosmoa.service.PlaceLikeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/place-like")
@Slf4j
public class PlaceLikeController {
    private final PlaceLikeService placeLikeService;

    public PlaceLikeController(PlaceLikeService placeLikeService) {
        this.placeLikeService = placeLikeService;
    }

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody PlaceLikeDTO dto) {
        try {
            PlaceLikeDTO saved = placeLikeService.insert(dto);
            ResponseDTO<PlaceLikeDTO> response = ResponseDTO.<PlaceLikeDTO>builder().data(saved).build();
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // 접속 유저의 해당 장소에 대한 좋아요 여부 조회
    @GetMapping("")
    public ResponseEntity<?> readByPlaceIdAndUserId(@RequestParam int placeId,
                                                    @RequestParam int userId) {
        try {
            PlaceLikeDTO dto = PlaceLikeDTO.builder().placeId(placeId).userId(userId).build();
            boolean isLike = placeLikeService.existsByPlaceIdAndUserId(dto);
            return ResponseEntity.ok().body(ResponseDTO.builder().data(isLike).build());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // 해당 장소에 대한 좋아요 개수 조회
    @GetMapping("/count")
    public ResponseEntity<?> countByPlaceId(@RequestParam int placeId) {
        try {
            int count = placeLikeService.countByPlaceId(placeId);
            return ResponseEntity.ok().body(ResponseDTO.builder().data(count).build());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseDTO.builder().error(e.getMessage()).build());
        }
    }

    @DeleteMapping("")
    public ResponseEntity<?> delete(@RequestBody PlaceLikeDTO dto) {
        try {
            boolean isDelete = placeLikeService.delete(dto);
            ResponseDTO response = ResponseDTO.builder().data(isDelete).build();
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseDTO.builder().error(e.getMessage()).build());
        }
    }
}
