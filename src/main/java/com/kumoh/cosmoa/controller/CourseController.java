package com.kumoh.cosmoa.controller;

import com.kumoh.cosmoa.dto.CourseDTO;
import com.kumoh.cosmoa.dto.ResponseDTO;
import com.kumoh.cosmoa.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;


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
        List<CourseDTO> dtos = courseService.findAll();
        ResponseDTO<List<CourseDTO>> response = ResponseDTO.<List<CourseDTO>>builder().data(dtos).build();

        return ResponseEntity.ok().body(response);
    }
    
    @PostMapping("")
    public ResponseEntity<?> createCourse(CourseDTO courseDto) throws Exception{
    	int result = courseService.createCourse(courseDto);
    	
    	return ResponseEntity.ok().body(result);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable int id, CourseDTO courseDto) throws Exception{
    	long millis = System.currentTimeMillis();
    	courseDto.setId(id);
    	courseDto.setModified_date(new Date(millis));
    	int result = courseService.updateCourse(courseDto);
    	
    	return ResponseEntity.ok().body(result);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable int id) throws Exception{
    	int result = courseService.deleteCourse(id);
    	
    	return ResponseEntity.ok().body(result);
    }
}
