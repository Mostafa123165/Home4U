package com.service.freelancer.controller;

import com.service.base.controller.BaseLkpControllerImpl;
import com.service.base.model.SuccessResponse;
import com.service.base.model.SuccessResponseList;
import com.service.freelancer.dto.TechnicalWorkerServDto;
import com.service.freelancer.mapper.TechnicalWorkerServMapper;
import com.service.freelancer.model.TechnicalWorkerServ;
import com.service.freelancer.service.TechnicalWorkerServService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/technical-worker-services")
@Tag(name = "TechnicalWorkerService")
public class TechnicalWorkerServController extends BaseLkpControllerImpl<TechnicalWorkerServ, TechnicalWorkerServDto,Integer> {

    private final TechnicalWorkerServService technicalWorkerServService;

    private final TechnicalWorkerServMapper technicalWorkerServMapper;

    @GetMapping("/service/{id}")
    @Operation(summary = "Get Technical Worker service")
    public ResponseEntity<?> service (@PathVariable Long id) {
        List<TechnicalWorkerServDto> technicalWorkerServs =technicalWorkerServMapper.map(technicalWorkerServService.getService(id));
        return ResponseEntity.ok(new SuccessResponseList<>(technicalWorkerServs));
    }


    @GetMapping("/service")
    @Operation(summary = "Get his own Technical Worker services")
    public ResponseEntity<?> getOwnEngineerServices (@RequestParam Long userId) {
        List<TechnicalWorkerServDto> technicalWorkerServs =technicalWorkerServMapper.map(technicalWorkerServService.getOwnEngineerServices(userId));
        return ResponseEntity.ok(new SuccessResponseList<>(technicalWorkerServs));
    }

    @PutMapping("/service/update")
    @Operation(summary = "Get his own Technical Worker services")
    public ResponseEntity<?> updateOwnEngineerServices (@RequestParam Long userId,@RequestBody List<TechnicalWorkerServDto> technicalWorkerServs) {
        technicalWorkerServService.updateOwnEngineerServices(userId,technicalWorkerServMapper.unMap(technicalWorkerServs));
        return ResponseEntity.ok(new SuccessResponse<>(true));
    }

}
