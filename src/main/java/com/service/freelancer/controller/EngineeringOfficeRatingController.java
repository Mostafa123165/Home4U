package com.service.freelancer.controller;

import com.service.base.controller.BaseControllerImpl;
import com.service.base.model.SuccessResponse;
import com.service.freelancer.dto.EngineeringOfficeDto;
import com.service.freelancer.dto.EngineeringOfficeRatingDto;
import com.service.freelancer.mapper.EngineeringOfficeRatingMapper;
import com.service.freelancer.model.EngineeringOfficeRating;
import com.service.freelancer.service.EngineeringOfficeRatingService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/engineering-office-rating")
@Tag(name = "EngineeringOfficeRating")
public class EngineeringOfficeRatingController extends BaseControllerImpl<EngineeringOfficeRating, EngineeringOfficeRatingDto, Long> {

    private final EngineeringOfficeRatingMapper engineeringOfficeRatingMapper;
    private final EngineeringOfficeRatingService engineeringOfficeRatingService;

    @GetMapping("/rate/{engineeringOfficeId}")
    public ResponseEntity<?> getByEngineerOfficeId(@PathVariable(required = false) Long engineeringOfficeId) {
        List<EngineeringOfficeRatingDto> engineeringOfficeRatingDtos =  engineeringOfficeRatingMapper.map(engineeringOfficeRatingService.findByEngineerOfficeId(engineeringOfficeId));
        return ResponseEntity.ok(new SuccessResponse<>(engineeringOfficeRatingDtos));
    }
}