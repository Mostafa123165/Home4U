package com.service.freelancer.controller;

import com.service.base.model.SuccessResponseList;
import com.service.freelancer.dto.AskEngineerPhotosDto;
import com.service.freelancer.mapper.AskEngineerPhotosMapper;
import com.service.freelancer.model.AskEngineerPhotos;
import com.service.freelancer.service.AskEngineerPhotosService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/ask-engineer-photos")
@Tag(name = "Ask Engineer Photos")
@RequiredArgsConstructor
public class AskEngineerPhotosController {

    private final AskEngineerPhotosService askEngineerPhotosService;
    private final AskEngineerPhotosMapper askEngineerPhotosMapper;

    @PostMapping("/all")
    public ResponseEntity<?> saveAll(@RequestBody List<AskEngineerPhotosDto> list) {
        List<AskEngineerPhotos> entity = askEngineerPhotosMapper.unMap(list);
        askEngineerPhotosService.saveAll(entity);
        return ResponseEntity.ok(new SuccessResponseList<>(askEngineerPhotosMapper.map(entity)));
    }
}
