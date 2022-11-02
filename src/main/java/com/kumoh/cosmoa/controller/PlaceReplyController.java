package com.kumoh.cosmoa.controller;

import com.kumoh.cosmoa.dto.PlaceReplyDTO;
import com.kumoh.cosmoa.dto.PlaceReplyResponseDTO;
import com.kumoh.cosmoa.dto.ResponseDTO;
import com.kumoh.cosmoa.service.PlaceReplyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/place_reply")
@Slf4j
public class PlaceReplyController {
    private final PlaceReplyService placeReplyService;

    public PlaceReplyController(PlaceReplyService placeReplyService) {
        this.placeReplyService = placeReplyService;
    }

    @PostMapping("")
    public ResponseEntity<?> create(PlaceReplyDTO dto,
                                    MultipartFile img) {
        try {
            PlaceReplyDTO saved = placeReplyService.insert(dto, img);
            ResponseDTO<PlaceReplyDTO> response = ResponseDTO.<PlaceReplyDTO>builder().data(saved).build();
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{placeId}")
    public ResponseEntity<?> read(@PathVariable int placeId) {
        try {
            List<PlaceReplyResponseDTO> dtos = placeReplyService.findByPlaceId(placeId);
            ResponseDTO<List<PlaceReplyResponseDTO>> response =
                    ResponseDTO.<List<PlaceReplyResponseDTO>>builder().data(dtos).build();

            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{replyId}")
    public ResponseEntity<?> update(@PathVariable int replyId,
                                    PlaceReplyDTO dto,
                                    MultipartFile img) {
        try {
            log.info("dto exists : {}", dto != null);
            dto.setId(replyId);
            PlaceReplyDTO updated = placeReplyService.update(dto, img);
            ResponseDTO<PlaceReplyDTO> response = ResponseDTO.<PlaceReplyDTO>builder().data(updated).build();

            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{replyId}")
    public ResponseEntity<?> delete(@PathVariable int replyId) {
        try {
            placeReplyService.delete(replyId);

            return ResponseEntity.ok().body("delete done.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
