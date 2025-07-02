package com.service.freelancer.controller;

import com.service.base.controller.BaseControllerImpl;
import com.service.base.model.SearchRequest;
import com.service.base.model.SuccessResponse;
import com.service.base.model.SuccessResponseList;
import com.service.base.model.SuccessResponsePage;
import com.service.common.dto.GovernorateDto;
import com.service.common.mapper.GovernorateMapper;
import com.service.common.service.GovernorateService;
import com.service.freelancer.dto.*;
import com.service.freelancer.mapper.AskEngineerMapper;
import com.service.freelancer.mapper.EngineerTypeMapper;
import com.service.freelancer.mapper.UnitTypeMapper;
import com.service.freelancer.mapper.UrgencyLevelMapper;
import com.service.freelancer.model.AskEngineer;
import com.service.freelancer.service.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/ask-engineer")
@Tag(name = "Ask Engineer")
@RequiredArgsConstructor
public class AskEngineerController extends BaseControllerImpl<AskEngineer, AskEngineerDto, Long> {

    private final EngineerTypeService engineerTypeService;
    private final UnitTypeService unitTypeService;
    private final GovernorateService governorateService;
    private final UrgencyLevelService urgencyLevelService;
    private final AskEngineerService askEngineerService;


    private final EngineerTypeMapper engineerTypeMapper;
    private final UnitTypeMapper unitTypeMapper;
    private final GovernorateMapper governorateMapper;
    private final UrgencyLevelMapper urgencyLevelMapper;
    private final AskEngineerMapper askEngineerMapper;

    @GetMapping("/lkps")
    public ResponseEntity<?> getLkps() {
        AskEngineerLkpsDto askEngineerLkpsDto = new AskEngineerLkpsDto();
        askEngineerLkpsDto.setEngineerType(engineerTypeMapper.map(engineerTypeService.findAll()));
        askEngineerLkpsDto.setUnitType(unitTypeMapper.map(unitTypeService.findAll()));
        askEngineerLkpsDto.setGovernorate(governorateMapper.map(governorateService.findAll()));
        askEngineerLkpsDto.setUrgencyLevel(urgencyLevelMapper.map(urgencyLevelService.findAll()));
        return ResponseEntity.ok(new SuccessResponse<AskEngineerLkpsDto>(askEngineerLkpsDto));
    }

    @PostMapping("/filter")
    public ResponseEntity<?> filter (@Valid @RequestBody SearchRequest req){
        Page<AskEngineerDto> dtos =  askEngineerService.filter(Optional.ofNullable(req)).map(askEngineerMapper::map);
        return ResponseEntity.ok(new SuccessResponsePage<AskEngineerDto>(dtos));
    }

    @GetMapping("/my-asks")
    public ResponseEntity<?> getMyAsks () {
        List<AskEngineerDto> dtos = askEngineerMapper.map(askEngineerService.getMyAsks());
        return ResponseEntity.ok(new SuccessResponseList<AskEngineerDto>(dtos));
    }
}
