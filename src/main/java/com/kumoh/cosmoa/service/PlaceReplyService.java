package com.kumoh.cosmoa.service;

import com.kumoh.cosmoa.dto.PlaceReplyDTO;
import com.kumoh.cosmoa.dto.PlaceReplyResponseDTO;
import com.kumoh.cosmoa.mapper.PlaceReplyMapper;
import com.kumoh.cosmoa.util.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PlaceReplyService {
    private final PlaceReplyMapper placeReplyMapper;

    public PlaceReplyService(PlaceReplyMapper placeReplyMapper) {
        this.placeReplyMapper = placeReplyMapper;
    }

    public PlaceReplyDTO insert(PlaceReplyDTO dto, MultipartFile img) {
        String path = FileUtils.saveImage("C:\\workspace\\images\\place-reply", dto.getPlaceId() + "_" + dto.getUserId(), img);
        dto.setImgPath(path);

        if (placeReplyMapper.insertPlaceReply(dto) == 0) throw new RuntimeException("Insert PlaceReply failed. try again.");

        return null;
    }

    public List<PlaceReplyResponseDTO> findByPlaceId(int placeId) {
        List<PlaceReplyDTO> dtos = placeReplyMapper.findByPlaceId(placeId);

        return dtos.stream().map(PlaceReplyResponseDTO::new).collect(Collectors.toList());
    }

    public PlaceReplyDTO update(PlaceReplyDTO dto, MultipartFile img) {
        dto.setImgPath(placeReplyMapper.getPlaceReply(dto.getId()).getImgPath());
        log.info("update dto: {}", dto);

        if (img != null) {
            FileUtils.deleteImage(dto.getImgPath());
            String path = FileUtils.saveImage("C:\\workspace\\images\\place-reply", dto.getPlaceId() + "_" + dto.getUserId(), img);
            dto.setImgPath(path);
        }

        if (placeReplyMapper.updatePlaceReply(dto) == 0) throw new RuntimeException("Update PlaceReply failed. try again.");

        return null;
    }

    public boolean delete(int id) {
        PlaceReplyDTO dto = placeReplyMapper.getPlaceReply(id);
        FileUtils.deleteImage(dto.getImgPath());

        if (placeReplyMapper.deletePlaceReply(dto) == 0) throw new RuntimeException("Delete PlaceReply failed. try again.");

        return true;
    }
}
