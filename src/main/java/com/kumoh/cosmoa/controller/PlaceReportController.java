package com.kumoh.cosmoa.controller;

import com.kumoh.cosmoa.dto.PlaceReportDTO;
import com.kumoh.cosmoa.dto.response.PlaceReportResponseDTO;
import com.kumoh.cosmoa.dto.ResponseDTO;
import com.kumoh.cosmoa.service.PlaceReportService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/place-report")
public class PlaceReportController {
    private final PlaceReportService placeReportService;

    public PlaceReportController(PlaceReportService placeReportService) {
        this.placeReportService = placeReportService;
    }

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody PlaceReportDTO dto) {
        try {
            PlaceReportDTO saved = placeReportService.insert(dto);
            ResponseDTO<PlaceReportDTO> response = ResponseDTO.<PlaceReportDTO>builder().data(saved).build();
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseDTO.builder().error(e.getMessage()).build());
        }
    }

    @GetMapping("")
    public ResponseEntity<?> read() {
        try {
            List<PlaceReportResponseDTO> dtos = placeReportService.findAll();
            ResponseDTO<List<PlaceReportResponseDTO>> response  =
                    ResponseDTO.<List<PlaceReportResponseDTO>>builder().data(dtos).build();
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseDTO.builder().error(e.getMessage()).build());
        }
    }

    @DeleteMapping("/{reportId}")
    public ResponseEntity<?> delete(@PathVariable int reportId) {
        try {
            boolean isDelete = placeReportService.delete(reportId);
            if (!isDelete) throw new RuntimeException("Delete failed. try again.");

            ResponseDTO<Object> response = ResponseDTO.builder().data(isDelete).build();
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseDTO.builder().error(e.getMessage()).build());
        }
    }
}
