package com.service.freelancer.dto;

import com.service.business.dto.ProductMaterialDto;
import com.service.common.dto.GovernorateDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class AskWorkerLkpsDto {

    private List<TechnicalWorkerTypeDto> workerType;

    private List<UnitTypeDto> unitType;

    private List<GovernorateDto> governorate;

    private List<ProductMaterialDto> material;
}
