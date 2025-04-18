package com.service.freelancer.controller;

import com.service.base.controller.BaseControllerImpl;
import com.service.base.model.SuccessResponse;
import com.service.business.mapper.ProductMaterialMapper;
import com.service.business.service.ProductMaterialService;
import com.service.common.mapper.GovernorateMapper;
import com.service.common.service.GovernorateService;
import com.service.freelancer.dto.AskEngineerLkpsDto;
import com.service.freelancer.dto.AskWorkerDto;
import com.service.freelancer.dto.AskWorkerLkpsDto;
import com.service.freelancer.mapper.TechnicalWorkerTypeMapper;
import com.service.freelancer.mapper.UnitTypeMapper;
import com.service.freelancer.model.AskWorker;
import com.service.freelancer.service.TechnicalWorkerTypeService;
import com.service.freelancer.service.UnitTypeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/ask-worker")
@Tag(name = "Ask Worker")
@RequiredArgsConstructor
public class AskWorkerController extends BaseControllerImpl<AskWorker, AskWorkerDto, Long> {

    private final TechnicalWorkerTypeService workerTypeService;
    private final UnitTypeService unitTypeService;
    private final GovernorateService governorateService;
    private final ProductMaterialService productMaterialService;


    private final TechnicalWorkerTypeMapper workerTypeMapper;
    private final UnitTypeMapper unitTypeMapper;
    private final GovernorateMapper governorateMapper;
    private final ProductMaterialMapper productMaterialMapper;

    @GetMapping("/lkps")
    public ResponseEntity<?> getLkps() {
        AskWorkerLkpsDto askWorkerLkpsDto = new AskWorkerLkpsDto();
        askWorkerLkpsDto.setWorkerType(workerTypeMapper.map(workerTypeService.findAll()));
        askWorkerLkpsDto.setUnitType(unitTypeMapper.map(unitTypeService.findAll()));
        askWorkerLkpsDto.setGovernorate(governorateMapper.map(governorateService.findAll()));
        askWorkerLkpsDto.setMaterial(productMaterialMapper.map(productMaterialService.findAll()));
        return ResponseEntity.ok(new SuccessResponse<AskWorkerLkpsDto>(askWorkerLkpsDto));
    }

}
