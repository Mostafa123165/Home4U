package com.service.freelancer.controller;

import com.service.base.controller.BaseLkpControllerImpl;
import com.service.base.model.SuccessResponseList;
import com.service.freelancer.dto.TechnicalWorkerServDto;
import com.service.freelancer.mapper.TechnicalWorkerServMapper;
import com.service.freelancer.model.TechnicalWorkerServ;
import com.service.freelancer.service.TechnicalWorkerServService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/technical-worker-services")
@Tag(name = "TechnicalWorkerService")
public class TechnicalWorkerServController extends BaseLkpControllerImpl<TechnicalWorkerServ, TechnicalWorkerServDto,Integer> {

    private final TechnicalWorkerServService technicalWorkerServService;

    private final TechnicalWorkerServMapper technicalWorkerServMapper;

    @GetMapping("/service/{id}")
    @Operation(summary = "Get engineer service")
    public ResponseEntity<?> service (@PathVariable Long id) {
        List<TechnicalWorkerServDto> engineerServs =technicalWorkerServMapper.map(technicalWorkerServService.getService(id));
        return ResponseEntity.ok(new SuccessResponseList<>(engineerServs));
    }

}
