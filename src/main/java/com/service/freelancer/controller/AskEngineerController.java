package com.service.freelancer.controller;

import com.service.base.controller.BaseControllerImpl;
import com.service.base.model.SuccessResponse;
import com.service.common.dto.GovernorateDto;
import com.service.common.mapper.GovernorateMapper;
import com.service.common.service.GovernorateService;
import com.service.freelancer.dto.*;
import com.service.freelancer.mapper.EngineerTypeMapper;
import com.service.freelancer.mapper.UnitTypeMapper;
import com.service.freelancer.mapper.UrgencyLevelMapper;
import com.service.freelancer.model.AskEngineer;
import com.service.freelancer.service.EngineerTypeService;
import com.service.freelancer.service.UnitTypeService;
import com.service.freelancer.service.UrgencyLevelService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/ask-engineer")
@Tag(name = "Ask Engineer")
@RequiredArgsConstructor
public class AskEngineerController extends BaseControllerImpl<AskEngineer, AskEngineerDto, Long> {

    private final EngineerTypeService engineerTypeService;
    private final UnitTypeService unitTypeService;
    private final GovernorateService governorateService;
    private final UrgencyLevelService urgencyLevelService;


    private final EngineerTypeMapper engineerTypeMapper;
    private final UnitTypeMapper unitTypeMapper;
    private final GovernorateMapper governorateMapper;
    private final UrgencyLevelMapper urgencyLevelMapper;

    @GetMapping("/lkps")
    public ResponseEntity<?> getLkps() {
        AskEngineerLkpsDto askEngineerLkpsDto = new AskEngineerLkpsDto();
        askEngineerLkpsDto.setEngineerType(engineerTypeMapper.map(engineerTypeService.findAll()));
        askEngineerLkpsDto.setUnitType(unitTypeMapper.map(unitTypeService.findAll()));
        askEngineerLkpsDto.setGovernorate(governorateMapper.map(governorateService.findAll()));
        askEngineerLkpsDto.setUrgencyLevel(urgencyLevelMapper.map(urgencyLevelService.findAll()));
        return ResponseEntity.ok(new SuccessResponse<AskEngineerLkpsDto>(askEngineerLkpsDto));
    }
}
