package com.service.freelancer.controller;

import com.service.base.controller.BaseControllerImpl;
import com.service.freelancer.dto.TechnicalWorkerRatingDto;
import com.service.freelancer.model.TechnicalWorkerRating;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/technical-worker-rating")
@Tag(name = "TechnicalWorker")
public class TechnicalWorkerRatingController extends BaseControllerImpl<TechnicalWorkerRating, TechnicalWorkerRatingDto,Long> {
}
