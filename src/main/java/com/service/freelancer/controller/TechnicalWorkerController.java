package com.service.freelancer.controller;

import com.service.base.controller.BaseControllerImpl;
import com.service.base.model.SuccessResponse;
import com.service.freelancer.dto.TechnicalWorkerDto;
import com.service.freelancer.mapper.TechnicalWorkerMapper;
import com.service.freelancer.model.TechnicalWorker;
import com.service.freelancer.service.TechnicalWorkerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/technical-workers")
@Tag(name = "TechnicalWorker")
public class TechnicalWorkerController extends BaseControllerImpl<TechnicalWorker, TechnicalWorkerDto,Long> {

    private final TechnicalWorkerService technicalWorkerService;
    private final TechnicalWorkerMapper technicalWorkerMapper;

    @GetMapping("/user")
    public ResponseEntity<?> getByUserId(@RequestParam(required = false) Long userId) {
        return ResponseEntity.ok(new SuccessResponse<>(technicalWorkerMapper.map(technicalWorkerService.findByUserId(userId))));
    }

}
