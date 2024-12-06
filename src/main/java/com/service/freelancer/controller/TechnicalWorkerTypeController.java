package com.service.freelancer.controller;

import com.service.base.controller.BaseLkpControllerImpl;
import com.service.freelancer.dto.TechnicalWorkerTypeDto;
import com.service.freelancer.model.TechnicalWorkerType;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/technical-worker-types")
@Tag(name = "TechnicalWorkerType")
public class TechnicalWorkerTypeController extends BaseLkpControllerImpl<TechnicalWorkerType, TechnicalWorkerTypeDto,Integer> {
}
