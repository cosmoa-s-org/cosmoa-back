package com.kumoh.cosmoa.mapper;

import com.kumoh.cosmoa.dto.PlaceReportDTO;
import com.kumoh.cosmoa.dto.response.PlaceReportResponseDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PlaceReportMapper {
    List<PlaceReportResponseDTO> findAll();
    int insertPlaceReport(@Param("param")PlaceReportDTO dto);
    int deletePlaceReport(@Param("reportId") int reportId);
    int updatePlaceReport(PlaceReportDTO dto);
}
