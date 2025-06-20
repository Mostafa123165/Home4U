package com.service.business.controller;

import com.service.base.model.SuccessResponse;
import com.service.business.mapper.*;
import com.service.business.model.BusinessConfigResponse;
import com.service.business.service.*;
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

    private final BusinessTypeCategoryService businessTypeCategoryService;
    private final BusinessTypeCategoryMapper businessTypeCategoryMapper;

    private final HomeFurnishingRequestTypeService homeFurnishingRequestTypeService;
    private final HomeFurnishingRequestTypeMapper homeFurnishingRequestTypeMapper;

    private final FurnitureTypeService furnitureTypeService;
    private final FurnitureTypeMapper furnitureTypeMapper;

    private final DevicesAttachedService devicesAttachedService;
    private final DevicesAttachedMapper devicesAttachedMapper;

    private final KitchenTypeService kitchenTypeService;
    private final KitchenTypeMapper kitchenTypeMapper;


    @GetMapping
    public ResponseEntity<Object> getPortalConfig() {

        BusinessConfigResponse businessConfigResponse = new BusinessConfigResponse();

        businessConfigResponse.setColors(colorMapper.map(colorService.findAll()));
        businessConfigResponse.setProductMaterial(productMaterialMapper.map(productMaterialService.findAll()));
        businessConfigResponse.setProductBaseUnits(productBaseUnitMapper.map(productBaseUnitService.findAll()));
        businessConfigResponse.setBusinessTypes(businessTypeMapper.map(businessTypeService.findAll()));
        businessConfigResponse.setBusinessTypeCategories(businessTypeCategoryMapper.map(businessTypeCategoryService.findAll()));
        businessConfigResponse.setHomeFurnishingRequestTypes(homeFurnishingRequestTypeMapper.map(homeFurnishingRequestTypeService.findAll()));
        businessConfigResponse.setDevicesAttacheds(devicesAttachedMapper.map(devicesAttachedService.findAll()));
        businessConfigResponse.setKitchenTypes(kitchenTypeMapper.map(kitchenTypeService.findAll()));
        businessConfigResponse.setFurnitureTypes(furnitureTypeMapper.map(furnitureTypeService.findAll()));


        return ResponseEntity.ok(new SuccessResponse<BusinessConfigResponse>(businessConfigResponse));
    }
}
