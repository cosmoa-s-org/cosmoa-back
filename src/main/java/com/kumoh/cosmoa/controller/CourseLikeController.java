package com.kumoh.cosmoa.controller;

import com.kumoh.cosmoa.dto.CourseLikeDTO;
import com.kumoh.cosmoa.dto.PlaceLikeDTO;
import com.kumoh.cosmoa.dto.ResponseDTO;
import com.kumoh.cosmoa.service.CourseLikeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
            return ResponseEntity.badRequest().body(ResponseDTO.builder().error(e.getMessage()).build());
        }
    }
    
 // 접속 유저의 해당 장소에 대한 좋아요 여부 조회
    @GetMapping("")
    public ResponseEntity<?> existsByCourseIdAndUserId(@RequestParam int courseId,
                                                    @RequestParam int userId) {
        try {
            CourseLikeDTO dto = CourseLikeDTO.builder().courseId(courseId).userId(userId).build();
            int isLike = courseLikeService.existsByCourseIdAndUserId(dto);
            return ResponseEntity.ok().body(ResponseDTO.builder().data(isLike).build());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseDTO.builder().error(e.getMessage()).build());
        }
    }
    
    //좋아요 누르기
    @PostMapping("")
    public ResponseEntity<?> createCourseLike(@RequestBody CourseLikeDTO courseLikeDto) {
        try {
            int result = courseLikeService.createCourseLike(courseLikeDto);
            return ResponseEntity.ok().body(ResponseDTO.builder().data("Like done.").build());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseDTO.builder().error(e.getMessage()).build());
        }
    }
    
    @DeleteMapping("/{likeId}")
    public ResponseEntity<?> deleteCourse(@PathVariable int likeId) {
        try {
            int result = courseLikeService.deleteCourseLike(likeId);
            return ResponseEntity.ok().body(ResponseDTO.builder().data("Delete course done.").build());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseDTO.builder().error(e.getMessage()).build());
        }
    }
}
