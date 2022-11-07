package com.kumoh.cosmoa.controller;

import com.kumoh.cosmoa.dto.CourseLikeDTO;
import com.kumoh.cosmoa.dto.ResponseDTO;
import com.kumoh.cosmoa.service.CourseLikeService;
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
@RequestMapping("/course-like")
@Slf4j
public class CourseLikeController {
    private CourseLikeService courseLikeService;

    public CourseLikeController(CourseLikeService courseLikeService) {
        this.courseLikeService = courseLikeService;
    }

    @GetMapping("")
    public ResponseEntity<?> getCourseLikeList() {
        List<CourseLikeDTO> dtos = courseLikeService.findAll();
        ResponseDTO<List<CourseLikeDTO>> response = ResponseDTO.<List<CourseLikeDTO>>builder().data(dtos).build();

        return ResponseEntity.ok().body(response);
    }
    
    @PostMapping("")
    public ResponseEntity<?> createCourseLike(CourseLikeDTO courseLikeDto) throws Exception{
    	int result = courseLikeService.createCourseLike(courseLikeDto);
    	
    	return ResponseEntity.ok().body(result);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCourseLike(@PathVariable int id, CourseLikeDTO courseLikeDto) throws Exception{
    	courseLikeDto.setId(id);
    	int result = courseLikeService.updateCourseLike(courseLikeDto);
    	
    	return ResponseEntity.ok().body(result);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable int id) throws Exception{
    	int result = courseLikeService.deleteCourseLike(id);
    	
    	return ResponseEntity.ok().body(result);
    }
}
