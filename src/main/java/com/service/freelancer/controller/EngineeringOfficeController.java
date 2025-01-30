package com.service.freelancer.controller;

import com.service.base.controller.BaseControllerImpl;
import com.service.freelancer.dto.EngineeringOfficeDto;
import com.service.freelancer.model.EngineeringOffice;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/engineering-office")
@Tag(name = "Engineering Office")
public class EngineeringOfficeController extends BaseControllerImpl<EngineeringOffice, EngineeringOfficeDto,Long> {
}
