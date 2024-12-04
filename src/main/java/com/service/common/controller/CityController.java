package com.service.common.controller;

import com.service.base.controller.BaseLkpControllerImpl;
import com.service.base.model.SuccessResponse;
import com.service.common.dto.CityDto;
import com.service.common.mapper.CityMapper;
import com.service.common.model.City;
import com.service.common.service.CityService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cities")
@AllArgsConstructor
@Tag(name = "City")
public class CityController extends BaseLkpControllerImpl<City, CityDto,Integer> {

    private final CityService cityService;
    private final CityMapper cityMapper;

    @GetMapping("/governorate/{governorateId}")
    public ResponseEntity<?> findByGovernorateId(@PathVariable Integer governorateId) {
        return ResponseEntity.ok(new SuccessResponse<>(cityMapper.map(cityService.findByGovernorateId(governorateId))));
    }
}
