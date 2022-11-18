package com.kumoh.cosmoa.service;


import com.kumoh.cosmoa.dto.PlaceReportDTO;
import com.kumoh.cosmoa.dto.response.PlaceReportResponseDTO;
import com.kumoh.cosmoa.mapper.PlaceReportMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PlaceReportService {
    private final PlaceReportMapper placeReportMapper;

    public PlaceReportService(PlaceReportMapper placeReportMapper) {
        this.placeReportMapper = placeReportMapper;
    }

    public PlaceReportDTO insert(PlaceReportDTO dto) {
        if (placeReportMapper.insertPlaceReport(dto) == 0) throw new RuntimeException("Insert PlaceReport failed. try again.");
        return null;
    }

    public List<PlaceReportResponseDTO> findAll() {
        //log.info("PlaceReportResponseDTO : {}", placeReportMapper.findAll().get(0));
    	List<PlaceReportResponseDTO> dtos = placeReportMapper.findAll();
    	dtos.forEach(d -> d.loadImage());
        return dtos;
    }

    public boolean delete(int reportId) {
        return placeReportMapper.deletePlaceReport(reportId) == 1;
    }
}
