package com.kumoh.cosmoa.controller;

import com.kumoh.cosmoa.dto.request.CourseComposeRequestDTO;
import com.kumoh.cosmoa.dto.response.CourseComposeResponseDTO;
import com.kumoh.cosmoa.dto.ResponseDTO;
import com.kumoh.cosmoa.service.CourseComposeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/course-compose")
@Slf4j
public class CourseComposeController {
    private final CourseComposeService courseComposeService;

    public CourseComposeController(CourseComposeService courseComposeService) {
        this.courseComposeService = courseComposeService;
    }

    @PutMapping("")
    public ResponseEntity<?> update(@RequestBody CourseComposeRequestDTO dto) {
        try {

            return ResponseEntity.ok().body(null);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseDTO.builder().error(e.getMessage()).build());
        }
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<?> readByCourseId(@PathVariable int courseId) {
        try {
            List<CourseComposeResponseDTO> dtos = courseComposeService.findByCourseId(courseId);
            ResponseDTO<List<CourseComposeResponseDTO>> response =
                    ResponseDTO.<List<CourseComposeResponseDTO>>builder().data(dtos).build();

            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseDTO.builder().error(e.getMessage()).build());
        }
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<?> deleteByCourseId(@PathVariable int courseId) {
        try {
            courseComposeService.deleteByCourseId(courseId);
            return ResponseEntity.ok().body(ResponseDTO.builder().data("Delete compose done.").build());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseDTO.builder().error(e.getMessage()).build());
        }
    }
}
