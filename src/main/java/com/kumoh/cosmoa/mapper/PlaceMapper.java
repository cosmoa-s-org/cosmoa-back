package com.kumoh.cosmoa.mapper;

import com.kumoh.cosmoa.dto.PlaceDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PlaceMapper {
    List<PlaceDTO> getPlaceList();
    List<PlaceDTO> findByNameAndAddress(@Param("search") String search);
    PlaceDTO getPlace(@Param("placeId") int placeId);

    int insertPlace(@Param("param") PlaceDTO dto);
    int updatePlace(@Param("param") PlaceDTO dto);
    int deletePlace(@Param("param") PlaceDTO dto);
}
