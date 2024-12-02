package com.service.common.controller;

import com.service.base.controller.BaseLkpControllerImpl;
import com.service.common.dto.CityDto;
import com.service.common.dto.GovernorateDto;
import com.service.common.model.City;
import com.service.common.model.Governorate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/governorates")
@AllArgsConstructor
@Tag(name = "Governorate")
public class GovernorateController extends BaseLkpControllerImpl<Governorate, GovernorateDto,Integer> {
}
