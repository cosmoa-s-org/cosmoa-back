package com.kumoh.cosmoa.controller;

import com.kumoh.cosmoa.dto.*;
import com.kumoh.cosmoa.dto.request.CourseRequestDTO;
import com.kumoh.cosmoa.dto.response.CourseDetailResponseDTO;
import com.kumoh.cosmoa.dto.response.CourseResponseDTO;
import com.kumoh.cosmoa.service.CourseComposeService;
import com.kumoh.cosmoa.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/course")
@Slf4j
public class CourseController {
    private CourseService courseService;
    private CourseComposeService courseComposeService;

    public CourseController(CourseService courseService,
                            CourseComposeService courseComposeService) {
        this.courseService = courseService;
        this.courseComposeService = courseComposeService;
    }

    @GetMapping("")
    public ResponseEntity<?> getCourseList() {
        try {
            List<CourseResponseDTO> dtos = courseService.findCourseResponseList();
            ResponseDTO<List<CourseResponseDTO>> response = ResponseDTO.<List<CourseResponseDTO>>builder().data(dtos).build();

            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseDTO.builder().error(e.getMessage()).build());
        }
    }
    
    @GetMapping("/hot")
    public ResponseEntity<?> getHotCourseList() {
        try {
            List<CourseResponseDTO> dtos = courseService.findHotCourseResponseList();
            ResponseDTO<List<CourseResponseDTO>> response = ResponseDTO.<List<CourseResponseDTO>>builder().data(dtos).build();

            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseDTO.builder().error(e.getMessage()).build());
        }
    }

    @GetMapping("/location")
    public ResponseEntity<?> searchByLatLng(@RequestParam("lat") String lat,
                                            @RequestParam("lng") String lng) {
        try {
            List<CourseResponseDTO> dtos = courseService.searchByLatLng(lat, lng);
            ResponseDTO<List<CourseResponseDTO>> response = ResponseDTO.<List<CourseResponseDTO>>builder().data(dtos).build();

            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseDTO.builder().error(e.getMessage()).build());
        }
    }

    @GetMapping("/detail")
    public ResponseEntity<?> getCourseDetail(@RequestParam("courseId") int courseId,
                                             @RequestParam("userId") int userId) {
        try {
            CourseDetailResponseDTO dto = courseService.findCourseDetail(courseId, userId);
            ResponseDTO<CourseDetailResponseDTO> response = ResponseDTO.<CourseDetailResponseDTO>builder().data(dto).build();

            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseDTO.builder().error(e.getMessage()).build());
        }
    }
    
    @PostMapping("")
    public ResponseEntity<?> createCourse(@RequestBody CourseRequestDTO dto) {
        /*
         * POST /course
         * {
         *      "course" : {
         *          "userId" : 1,
         *          "name" : "Test course",
         *          "description" : "This is test course"
         *      },
         *      "compose" : [
         *          {
         *              "costTime" : 60,
         *              "sequence" : 1,
         *              "placeId" : 2
         *          },
         *          ...
         *      ]
         * }
         *
         * 1. Course 테이블 데이터 삽입 후 자동 생성된 CourseId 반환
         * 2. CourseId 셋팅 후 Compose 테이블 데이터 삽입
         */
        try {
            log.info("course request: {}", dto);
            int courseId = courseService.createCourse(dto.getCourse());
            courseComposeService.insertCompose(courseId, dto.getCompose());

            return ResponseEntity.ok().body(ResponseDTO.builder().data("Create course done!").build());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseDTO.builder().error(e.getMessage()).build());
        }

    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable int id, @RequestBody CourseDTO courseDto) {
        try {
            //    	long millis = System.currentTimeMillis()
            //      courseDto.setModified_date(new Date(millis));
            courseDto.setId(id);

            int result = courseService.updateCourse(courseDto);

            return ResponseEntity.ok().body(ResponseDTO.builder().data("Update course done.").build());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseDTO.builder().error(e.getMessage()).build());
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable int id) {
        try {
            int result = courseService.deleteCourse(id);

            return ResponseEntity.ok().body(ResponseDTO.builder().data("Delete course done.").build());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseDTO.builder().error(e.getMessage()).build());
        }

    }
}
