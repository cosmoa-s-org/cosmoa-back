package com.kumoh.cosmoa.controller;

import com.kumoh.cosmoa.dto.CourseReportDTO;
import com.kumoh.cosmoa.dto.ResponseDTO;
import com.kumoh.cosmoa.service.CourseReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/course-report")
@Slf4j
public class CourseReportController {
    private CourseReportService courseReportService;

    public CourseReportController(CourseReportService courseReportService) {
        this.courseReportService = courseReportService;
    }

    @GetMapping("")
    public ResponseEntity<?> getCourseReportList() {
        List<CourseReportDTO> dtos = courseReportService.findAll();
        ResponseDTO<List<CourseReportDTO>> response = ResponseDTO.<List<CourseReportDTO>>builder().data(dtos).build();

        return ResponseEntity.ok().body(response);
    }
    
    @PostMapping("")
    public ResponseEntity<?> createCourseReport(CourseReportDTO courseReportDto) throws Exception{
    	int result = courseReportService.createCourseReport(courseReportDto);
    	
    	return ResponseEntity.ok().body(result);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCourseReport(@PathVariable int id, CourseReportDTO courseReportDto) throws Exception{
    	courseReportDto.setId(id);
    	int result = courseReportService.updateCourseReport(courseReportDto);
    	
    	return ResponseEntity.ok().body(result);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourseReport(@PathVariable int id) throws Exception{
    	int result = courseReportService.deleteCourseReport(id);
    	
    	return ResponseEntity.ok().body(result);
    }
}
