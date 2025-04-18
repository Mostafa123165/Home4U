package com.service.freelancer.dto;

import com.service.base.dto.BaseEntityDto;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SelectCustomPackageDto extends BaseEntityDto<Long> {

    private String phoneNumber;

    private Boolean isInsideCompound;

    private UnitTypeDto unitType;

    private CustomPackageDto customPackage;
}
