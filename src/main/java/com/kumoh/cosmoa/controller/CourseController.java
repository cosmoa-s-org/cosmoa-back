package com.kumoh.cosmoa.controller;

import com.kumoh.cosmoa.dto.CourseDTO;
import com.kumoh.cosmoa.dto.ResponseDTO;
import com.kumoh.cosmoa.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("/course")
@Slf4j
public class CourseController {
    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("")
    public ResponseEntity<?> getCourseList() {
        try {
            List<CourseDTO> dtos = courseService.findAll();
            ResponseDTO<List<CourseDTO>> response = ResponseDTO.<List<CourseDTO>>builder().data(dtos).build();

            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseDTO.builder().error(e.getMessage()).build());
        }
    }
    
    @PostMapping("")
    public ResponseEntity<?> createCourse(@RequestBody CourseDTO courseDto) {
        try {
            int result = courseService.createCourse(courseDto);

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
