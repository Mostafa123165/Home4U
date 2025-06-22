package com.service.freelancer.controller;

import com.service.base.controller.BaseControllerImpl;
import com.service.base.model.SuccessResponse;
import com.service.freelancer.dto.EngineeringOfficeRatingDto;
import com.service.freelancer.dto.TechnicalWorkerRatingDto;
import com.service.freelancer.mapper.EngineeringOfficeRatingMapper;
import com.service.freelancer.mapper.TechnicalWorkerRatingMapper;
import com.service.freelancer.model.TechnicalWorkerRating;
import com.service.freelancer.service.EngineeringOfficeRatingService;
import com.service.freelancer.service.TechnicalWorkerRatingService;
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
@RequestMapping("api/v1/technical-worker-rating")
@Tag(name = "TechnicalWorker")
public class TechnicalWorkerRatingController extends BaseControllerImpl<TechnicalWorkerRating, TechnicalWorkerRatingDto,Long> {

    private final TechnicalWorkerRatingMapper technicalWorkerRatingMapper;
    private final TechnicalWorkerRatingService technicalWorkerRatingService;

    @GetMapping("/rate/{workerId}")
    public ResponseEntity<?> getByTechnicalWorkerRatingId(@PathVariable(required = false) Long workerId) {
        List<TechnicalWorkerRatingDto> technicalWorkerRatingDtos =  technicalWorkerRatingMapper.map(technicalWorkerRatingService.findByTechnicalWorkerRatingId(workerId));
        return ResponseEntity.ok(new SuccessResponse<>(technicalWorkerRatingDtos));
    }
}
