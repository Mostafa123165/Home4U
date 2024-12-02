package com.service.common.controller;

import com.service.base.controller.BaseLkpControllerImpl;
import com.service.common.dto.CityDto;
import com.service.common.model.City;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cities")
@AllArgsConstructor
@Tag(name = "City")
public class CityController extends BaseLkpControllerImpl<City, CityDto,Integer> {
}
