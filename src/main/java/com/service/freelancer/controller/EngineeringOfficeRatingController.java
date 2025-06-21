package com.service.freelancer.controller;

import com.service.base.controller.BaseControllerImpl;
import com.service.freelancer.dto.EngineeringOfficeRatingDto;
import com.service.freelancer.model.EngineeringOfficeRating;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/engineering-office-rating")
@Tag(name = "EngineeringOfficeRating")
public class EngineeringOfficeRatingController extends BaseControllerImpl<EngineeringOfficeRating, EngineeringOfficeRatingDto, Long> {
}
