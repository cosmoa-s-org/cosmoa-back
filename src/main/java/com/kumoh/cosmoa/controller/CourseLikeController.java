package com.kumoh.cosmoa.controller;

import com.kumoh.cosmoa.dto.CourseLikeDTO;
import com.kumoh.cosmoa.dto.PlaceLikeDTO;
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
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/course-like")
@Slf4j
public class CourseLikeController {
    private CourseLikeService courseLikeService;

    public CourseLikeController(CourseLikeService courseLikeService) {
        this.courseLikeService = courseLikeService;
    }
    
    //좋아요 갯수 조회
    @GetMapping("/count")
    public ResponseEntity<?> countByCourseId(@RequestParam int Id) {
        try {
            int count = courseLikeService.countByCourseId(Id);
            return ResponseEntity.ok().body(ResponseDTO.builder().data(count).build());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
 // 접속 유저의 해당 장소에 대한 좋아요 여부 조회
    @GetMapping("")
    public ResponseEntity<?> existsByCourseIdAndUserId(@RequestParam int courseId,
                                                    @RequestParam int userId) {
        try {
            CourseLikeDTO dto = CourseLikeDTO.builder().course_id(courseId).user_id(userId).build();
            int isLike = courseLikeService.existsByCourseIdAndUserId(dto);
            return ResponseEntity.ok().body(ResponseDTO.builder().data(isLike).build());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    //좋아요 누르기
    @PostMapping("")
    public ResponseEntity<?> createCourseLike(CourseLikeDTO courseLikeDto) {
    	try {
    		int result = courseLikeService.createCourseLike(courseLikeDto);
            return ResponseEntity.ok().body(result);
            
    	} catch (Exception e) {
    	
    		return ResponseEntity.badRequest().body(e.getMessage());
    	}
    }
    
    @DeleteMapping("/{likeId}")
    public ResponseEntity<?> deleteCourse(@PathVariable int likeId) {
    	try {
    		int result = courseLikeService.deleteCourseLike(likeId);
    		return ResponseEntity.ok().body(result);    		
    	} catch (Exception e) {
    		return ResponseEntity.badRequest().body(e.getMessage());
    	}
    }
}
