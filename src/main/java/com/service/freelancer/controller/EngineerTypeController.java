package com.service.freelancer.controller;

import com.service.base.controller.BaseLkpControllerImpl;
import com.service.freelancer.dto.EngineerTypeDto;
import com.service.freelancer.model.EngineerType;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/engineer-types")
@Tag(name = "EngineerType")
public class    EngineerTypeController extends BaseLkpControllerImpl<EngineerType, EngineerTypeDto,Integer> {
}
