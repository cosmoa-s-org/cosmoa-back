package com.kumoh.cosmoa.mapper;

import com.kumoh.cosmoa.dto.PlaceDTO;
import com.kumoh.cosmoa.dto.response.PlaceDetailResponseDTO;
import com.kumoh.cosmoa.dto.response.PlaceTableResponseDTO;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PlaceMapper {
    List<PlaceDTO> getPlaceList();
    List<PlaceDTO> findByNameAndAddress(@Param("search") String search);
    List<PlaceTableResponseDTO> getScrapedPlaceResponseList(@Param("userId") int userId);
    List<PlaceTableResponseDTO> getPostedPlaceResponseList(@Param("userId") int userId);

    PlaceDetailResponseDTO findByPlaceId(@Param("placeId") int placeId, @Param("userId") int userId);

    PlaceDTO getPlace(@Param("placeId") int placeId);

    int insertPlace(@Param("param") PlaceDTO dto);
    int updatePlace(@Param("param") PlaceDTO dto);
    int deletePlace(@Param("param") PlaceDTO dto);
}
