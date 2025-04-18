package com.service.freelancer.controller;

import com.service.base.controller.BaseControllerImpl;
import com.service.base.model.SuccessResponseList;
import com.service.freelancer.dto.AskWorkerPhotosDto;
import com.service.freelancer.mapper.AskWorkerPhotosMapper;
import com.service.freelancer.model.AskWorkerPhotos;
import com.service.freelancer.service.AskWorkerPhotosService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/ask-worker-photos")
@Tag(name = "Ask Worker Photos")
@RequiredArgsConstructor
public class AskWorkerPhotosController {
    private final AskWorkerPhotosService askWorkerPhotosService;
    private final AskWorkerPhotosMapper askWorkerPhotosMapper;

    @PostMapping("/all")
    public ResponseEntity<?> saveAll(@RequestBody List<AskWorkerPhotosDto> list) {
        List<AskWorkerPhotos> entity = askWorkerPhotosMapper.unMap(list);
        askWorkerPhotosService.saveAll(entity);
        return ResponseEntity.ok(new SuccessResponseList<>(askWorkerPhotosMapper.map(entity)));
    }
}
