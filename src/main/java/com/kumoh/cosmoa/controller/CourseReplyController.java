package com.kumoh.cosmoa.controller;

import com.kumoh.cosmoa.dto.CourseReplyDTO;
import com.kumoh.cosmoa.dto.ResponseDTO;
import com.kumoh.cosmoa.service.CourseReplyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.xml.ws.Response;

import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("/course_reply")
@Slf4j
public class CourseReplyController {
    private CourseReplyService courseReplyService;

    public CourseReplyController(CourseReplyService courseReplyService) {
        this.courseReplyService = courseReplyService;
    }

    @GetMapping("")
    public ResponseEntity<?> getCourseReplyList() {
        try {
            List<CourseReplyDTO> dtos = courseReplyService.findAll();
            ResponseDTO<List<CourseReplyDTO>> response = ResponseDTO.<List<CourseReplyDTO>>builder().data(dtos).build();

            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseDTO.builder().error(e.getMessage()).build());
        }
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<?> getCourseReplyListByCourseId(@PathVariable int courseId) {
        try {
            List<CourseReplyDTO> dtos = courseReplyService.findByCourseId(courseId);
            ResponseDTO<List<CourseReplyDTO>> response = ResponseDTO.<List<CourseReplyDTO>>builder().data(dtos).build();

            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseDTO.builder().error(e.getMessage()).build());
        }
    }
    
    @PostMapping("")
    public ResponseEntity<?> createReplyCourse(CourseReplyDTO courseReplyDto) {
        try {
            int result = courseReplyService.createCourseReply(courseReplyDto);

            return ResponseEntity.ok().body(ResponseDTO.builder().data("Create course reply done!").build());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseDTO.builder().error(e.getMessage()).build());
        }

    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCourseReply(@PathVariable int id, CourseReplyDTO courseReplyDto) {
        try {
            //    	long millis = System.currentTimeMillis();
            //      courseReplyDto.setModified_date(new Date(millis));
            courseReplyDto.setId(id);
            int result = courseReplyService.updateCourseReply(courseReplyDto);

            return ResponseEntity.ok().body(ResponseDTO.builder().data("Update course done.").build());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseDTO.builder().error(e.getMessage()).build());
        }

    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourseReply(@PathVariable int id) {
        try {
            int result = courseReplyService.deleteCourseReply(id);

            return ResponseEntity.ok().body(ResponseDTO.builder().data("Delete course done.").build());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseDTO.builder().error(e.getMessage()).build());
        }

    }
}
