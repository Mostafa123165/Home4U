package com.service.freelancer.controller;

import com.service.base.controller.BaseControllerImpl;
import com.service.freelancer.dto.EngineerRatingDto;
import com.service.freelancer.model.EngineerRating;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/engineer-rating")
@Tag(name = "EngineerRating")
public class EngineerRatingController extends BaseControllerImpl<EngineerRating, EngineerRatingDto,Long> {
}
