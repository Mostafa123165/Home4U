package com.service.freelancer.controller;

import com.service.base.controller.BaseControllerImpl;
import com.service.base.model.SuccessResponse;
import com.service.common.mapper.GovernorateMapper;
import com.service.common.service.GovernorateService;
import com.service.freelancer.dto.HomeRenovateDto;
import com.service.freelancer.dto.HomeRenovateLkpsDto;
import com.service.freelancer.mapper.UnitStatusesMapper;
import com.service.freelancer.mapper.UnitTypeMapper;
import com.service.freelancer.mapper.UnitWorkTypesMapper;
import com.service.freelancer.mapper.WorkSkillsMapper;
import com.service.freelancer.model.HomeRenovate;
import com.service.freelancer.service.UnitStatusesService;
import com.service.freelancer.service.UnitTypeService;
import com.service.freelancer.service.UnitWorkTypesService;
import com.service.freelancer.service.WorkSkillsService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    private final UnitStatusesMapper unitStatusesMapper;
    private final UnitTypeMapper unitTypeMapper;
    private final UnitWorkTypesMapper unitWorkTypesMapper;
    private final WorkSkillsMapper workSkillsMapper;
    private final GovernorateMapper governorateMapper;


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
}
