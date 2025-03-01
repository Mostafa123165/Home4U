package com.service.business.controller;

import com.service.base.model.SuccessResponse;
import com.service.business.mapper.BusinessTypeMapper;
import com.service.business.mapper.ColorMapper;
import com.service.business.mapper.ProductBaseUnitMapper;
import com.service.business.mapper.ProductMaterialMapper;
import com.service.business.model.BusinessConfigResponse;
import com.service.business.service.BusinessTypeService;
import com.service.business.service.ColorService;
import com.service.business.service.ProductBaseUnitService;
import com.service.business.service.ProductMaterialService;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Schema(name = "Business")
@RequestMapping("api/v1/business-config")
public class BusinessConfigController {


    private final ColorService colorService;
    private final ColorMapper colorMapper;

    private final ProductMaterialService productMaterialService;
    private final ProductMaterialMapper productMaterialMapper;

    private final ProductBaseUnitService productBaseUnitService;
    private final ProductBaseUnitMapper productBaseUnitMapper;

    private final BusinessTypeService businessTypeService;
    private final BusinessTypeMapper businessTypeMapper;

    @GetMapping
    public ResponseEntity<Object> getPortalConfig() {

        BusinessConfigResponse businessConfigResponse = new BusinessConfigResponse();

        businessConfigResponse.setColors(colorMapper.map(colorService.findAll()));
        businessConfigResponse.setProductMaterial(productMaterialMapper.map(productMaterialService.findAll()));
        businessConfigResponse.setProductBaseUnits(productBaseUnitMapper.map(productBaseUnitService.findAll()));
        businessConfigResponse.setBusinessTypes(businessTypeMapper.map(businessTypeService.findAll()));

        return ResponseEntity.ok(new SuccessResponse<BusinessConfigResponse>(businessConfigResponse));
    }
}
