package com.kumoh.cosmoa.service;

import com.kumoh.cosmoa.dto.ComposeDTO;
import com.kumoh.cosmoa.dto.response.ComposeResponseDTO;
import com.kumoh.cosmoa.dto.response.CourseComposeResponseDTO;
import com.kumoh.cosmoa.mapper.CourseComposeMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CourseComposeService {
    private final CourseComposeMapper courseComposeMapper;

    public CourseComposeService(CourseComposeMapper courseComposeMapper) {
        this.courseComposeMapper = courseComposeMapper;
    }
    public List<CourseComposeResponseDTO> findByCourseId(int courseId) {
        List<ComposeResponseDTO> list = courseComposeMapper.findByCourseId(courseId);
        List<CourseComposeResponseDTO> dtos =
                list.stream().map(CourseComposeResponseDTO::new).collect(Collectors.toList());
        return dtos;
    }

    public void insertCompose(int courseId, List<ComposeDTO> list) {
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setCourseId(courseId);
            courseComposeMapper.insertCompose(list.get(i));
        }
    }

    public void updateCompose(List<ComposeDTO> list) {
        for (int i = 0; i < list.size(); i++) {
            courseComposeMapper.updateCompose(list.get(i));
        }
    }

    public void deleteByCourseId(int courseId) {
        List<ComposeResponseDTO> list = courseComposeMapper.findByCourseId(courseId);
        for (int i = 0; i < list.size(); i++) {
            courseComposeMapper.deleteCompose(list.get(i).getId());
        }
    }
}
