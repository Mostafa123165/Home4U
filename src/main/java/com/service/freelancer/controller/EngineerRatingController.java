package com.service.freelancer.controller;

import com.service.base.controller.BaseControllerImpl;
import com.service.base.model.SuccessResponse;
import com.service.freelancer.dto.EngineerRatingDto;
import com.service.freelancer.dto.EngineeringOfficeRatingDto;
import com.service.freelancer.mapper.EngineerRatingMapper;
import com.service.freelancer.mapper.EngineeringOfficeRatingMapper;
import com.service.freelancer.model.EngineerRating;
import com.service.freelancer.service.EngineerRatingService;
import com.service.freelancer.service.EngineeringOfficeRatingService;
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
@RequestMapping("api/v1/engineer-rating")
@Tag(name = "EngineerRating")
public class EngineerRatingController extends BaseControllerImpl<EngineerRating, EngineerRatingDto,Long> {

    private final EngineerRatingMapper engineerRatingMapper;
    private final EngineerRatingService engineerRatingService;

    @GetMapping("/rate/{engineerId}")
    public ResponseEntity<?> getByEngineerIdId(@PathVariable(required = false) Long engineerId) {
        List<EngineerRatingDto> engineeringRatingDtos =  engineerRatingMapper.map(engineerRatingService.findByEngineerId(engineerId));
        return ResponseEntity.ok(new SuccessResponse<>(engineeringRatingDtos));
    }
}
