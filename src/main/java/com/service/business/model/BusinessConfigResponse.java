package com.service.business.model;

import com.service.business.dto.BusinessTypeDto;
import com.service.business.dto.ColorDto;
import com.service.business.dto.ProductBaseUnitDto;
import com.service.business.dto.ProductMaterialDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class BusinessConfigResponse {

    private List<ColorDto> colors;

    private List<ProductBaseUnitDto> productBaseUnits;

    private List<ProductMaterialDto> productMaterial;

    private List<BusinessTypeDto> businessTypes;
}