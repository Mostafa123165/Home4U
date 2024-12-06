package com.service.freelancer.controller;

import com.service.base.controller.BaseControllerImpl;
import com.service.freelancer.dto.TechnicalWorkerDto;
import com.service.freelancer.model.TechnicalWorker;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/technical-workers")
@Tag(name = "TechnicalWorker")
public class TechnicalWorkerController extends BaseControllerImpl<TechnicalWorker, TechnicalWorkerDto,Long> {
}
