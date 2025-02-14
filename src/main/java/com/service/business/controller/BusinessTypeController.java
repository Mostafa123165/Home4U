package com.service.business.controller;

import com.service.base.controller.BaseLkpControllerImpl;
import com.service.base.model.SuccessResponseList;
import com.service.business.dto.BusinessTypeDto;
import com.service.business.mapper.BusinessTypeMapper;
import com.service.business.model.BusinessType;
import com.service.business.service.BusinessTypeService;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Schema(name = "Business Type")
@RequestMapping("api/v1/business-types")
public class BusinessTypeController extends BaseLkpControllerImpl<BusinessType, BusinessTypeDto,Integer> {

    private final BusinessTypeService businessTypeService;
    private final BusinessTypeMapper businessTypeMapper;

    @GetMapping("/user-type/{userTypeId}")
    public ResponseEntity<?> findByUserType(@PathVariable Long userTypeId) {
        return ResponseEntity.ok(new SuccessResponseList<>(businessTypeMapper.map(businessTypeService.findByUserType(userTypeId))));
    }
}
