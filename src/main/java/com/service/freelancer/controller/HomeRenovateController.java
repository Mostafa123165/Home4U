package com.service.freelancer.controller;

import com.service.base.controller.BaseControllerImpl;
import com.service.base.model.SearchRequest;
import com.service.base.model.SuccessResponse;
import com.service.base.model.SuccessResponsePage;
import com.service.common.mapper.GovernorateMapper;
import com.service.common.service.GovernorateService;
import com.service.freelancer.dto.HomeRenovateDto;
import com.service.freelancer.dto.HomeRenovateLkpsDto;
import com.service.freelancer.dto.RequestDesignDto;
import com.service.freelancer.mapper.*;
import com.service.freelancer.model.HomeRenovate;
import com.service.freelancer.service.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/home-renovate")
@Tag(name = "Home Renovate")
@RequiredArgsConstructor
public class HomeRenovateController extends BaseControllerImpl<HomeRenovate, HomeRenovateDto, Long> {

    private final UnitStatusesService unitStatusesService;
    private final UnitTypeService unitTypeService;
    private final UnitWorkTypesService unitWorkTypesService;
    private final WorkSkillsService workSkillsService;
    private final GovernorateService governorateService;
    private final HomeRenovateService homeRenovateService;

    private final UnitStatusesMapper unitStatusesMapper;
    private final UnitTypeMapper unitTypeMapper;
    private final UnitWorkTypesMapper unitWorkTypesMapper;
    private final WorkSkillsMapper workSkillsMapper;
    private final GovernorateMapper governorateMapper;
    private final HomeRenovateMapper homeRenovateMapper;


    @GetMapping("/lkps")
    public ResponseEntity<?> getLkps() {
        HomeRenovateLkpsDto homeRenovateLkpsDto = new HomeRenovateLkpsDto();
        homeRenovateLkpsDto.setUnitStatuses(unitStatusesMapper.map(unitStatusesService.findAll()));
        homeRenovateLkpsDto.setUnitTypes(unitTypeMapper.map(unitTypeService.findAll()));
        homeRenovateLkpsDto.setUnitWorkTypes(unitWorkTypesMapper.map(unitWorkTypesService.findAll()));
        homeRenovateLkpsDto.setWorkSkills(workSkillsMapper.map(workSkillsService.findAll()));
        homeRenovateLkpsDto.setGovernorates(governorateMapper.map(governorateService.findAll()));
        return ResponseEntity.ok(new SuccessResponse<HomeRenovateLkpsDto>(homeRenovateLkpsDto));
    }

    @PostMapping("/filter")
    public ResponseEntity<?> filter (@Valid @RequestBody SearchRequest req){
        Page<HomeRenovateDto> dtos =  homeRenovateService.filter(Optional.ofNullable(req)).map(homeRenovateMapper::map);
        return ResponseEntity.ok(new SuccessResponsePage<HomeRenovateDto>(dtos));
    }

}
