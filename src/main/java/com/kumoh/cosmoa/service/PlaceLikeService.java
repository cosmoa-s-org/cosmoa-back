package com.kumoh.cosmoa.service;

import com.kumoh.cosmoa.dto.PlaceLikeDTO;
import com.kumoh.cosmoa.mapper.PlaceLikeMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PlaceLikeService {
    private final PlaceLikeMapper placeLikeMapper;

    public PlaceLikeService(PlaceLikeMapper placeLikeMapper) {
        this.placeLikeMapper = placeLikeMapper;
    }

    public PlaceLikeDTO insert(PlaceLikeDTO dto) {
        if (placeLikeMapper.insertPlaceLike(dto) == 0) {
            throw new RuntimeException("Insert PlaceLike failed. try again.");
        }

        return null;
    }

    public int countByPlaceId(int placeId) {
        return placeLikeMapper.countByPlaceId(placeId);
    }
    public boolean existsByPlaceIdAndUserId(PlaceLikeDTO dto) {
        return placeLikeMapper.countByPlaceIdAndUserId(dto) == 1;
    }

    public boolean delete(int likeId) {
        return placeLikeMapper.deletePlaceLike(likeId) == 1;
    }
}
