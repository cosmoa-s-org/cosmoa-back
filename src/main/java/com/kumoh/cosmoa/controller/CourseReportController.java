package com.kumoh.cosmoa.controller;

import com.kumoh.cosmoa.dto.CourseReportDTO;
import com.kumoh.cosmoa.dto.ResponseDTO;
import com.kumoh.cosmoa.dto.response.CourseReportResponseDTO;
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
        try {
            List<CourseReportResponseDTO> dtos = courseReportService.findAll();
            ResponseDTO<List<CourseReportResponseDTO>> response = ResponseDTO.<List<CourseReportResponseDTO>>builder().data(dtos).build();

            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseDTO.builder().error(e.getMessage()).build());
        }

    }
    
    @PostMapping("")
    public ResponseEntity<?> createCourseReport(CourseReportDTO courseReportDto) {
        try {
            int result = courseReportService.createCourseReport(courseReportDto);
            if(result==1)
            {
            	return ResponseEntity.ok().body(ResponseDTO.builder().data("코스 신고 등록 성공.").build());            	
            }
            else
            {
            	return ResponseEntity.ok().body(ResponseDTO.builder().data("코스 신고 등록 실패.").build());            	
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseDTO.builder().error(e.getMessage()).build());
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCourseReport(@PathVariable int id, CourseReportDTO courseReportDto) {
        try {
            courseReportDto.setId(id);
            int result = courseReportService.updateCourseReport(courseReportDto);
            if(result==1)
            {
            	return ResponseEntity.ok().body(ResponseDTO.builder().data("코스 신고 수정 성공.").build());            	
            }
            else
            {
            	return ResponseEntity.ok().body(ResponseDTO.builder().data("코스 신고 수정 실패.").build());            	
            }

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseDTO.builder().error(e.getMessage()).build());
        }

    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourseReport(@PathVariable int id) {
        try {
            int result = courseReportService.deleteCourseReport(id);
            if(result==1)
            {
            	return ResponseEntity.ok().body(ResponseDTO.builder().data("코스 신고 삭제 성공.").build());
            }
            else
            {
            	{
                	return ResponseEntity.ok().body(ResponseDTO.builder().data("코스 신고 삭제 실패.").build());
                }
            }

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseDTO.builder().error(e.getMessage()).build());
        }

    }
}
