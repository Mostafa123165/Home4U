package com.service.freelancer.controller;

import com.service.base.controller.BaseLkpControllerImpl;
import com.service.freelancer.dto.EngineeringOfficeFieldDto;
import com.service.freelancer.model.EngineeringOfficeField;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/engineering-office-field")
@Tag(name = "Engineering Office Field")
public class EngineeringOfficeFieldController extends BaseLkpControllerImpl<EngineeringOfficeField, EngineeringOfficeFieldDto,Integer> {
}
