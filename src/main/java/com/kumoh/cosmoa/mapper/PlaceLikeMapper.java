package com.kumoh.cosmoa.mapper;

import com.kumoh.cosmoa.dto.PlaceLikeDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PlaceLikeMapper {
    int countByPlaceId(@Param("placeId") int placeId);
    int countByPlaceIdAndUserId(@Param("param") PlaceLikeDTO dto);
    int insertPlaceLike(@Param("param") PlaceLikeDTO dto);
    int deletePlaceLike(@Param("param")  PlaceLikeDTO dto);
}
