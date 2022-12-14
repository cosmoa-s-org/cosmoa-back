package com.kumoh.cosmoa.mapper;

import com.kumoh.cosmoa.dto.PlaceReplyDTO;
import com.kumoh.cosmoa.dto.response.PlaceReplyResponseDTO;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface PlaceReplyMapper {
    List<PlaceReplyResponseDTO> findByPlaceId(@Param("placeId") int placeId);
    PlaceReplyDTO getPlaceReply(@Param("replyId") int replyId);

    int insertPlaceReply(@Param("param") PlaceReplyDTO dto);
    int updatePlaceReply(@Param("param") PlaceReplyDTO dto);
    int deletePlaceReply(@Param("param") PlaceReplyDTO dto);
}
