package com.service.freelancer.dto;

import com.service.base.dto.BaseEntityDto;
import com.service.business.dto.ProductMaterialDto;
import com.service.common.dto.CityDto;
import com.service.common.dto.GovernorateDto;
import com.service.userManagement.dto.UserDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class AskWorkerDto extends BaseEntityDto<Long> {

    private String projectName;

    private String phoneNumber;

    private String projectDescription;

    private TechnicalWorkerTypeDto workerType;

    private UnitTypeDto unitType;

    private CityDto city;

    private GovernorateDto governorate;

    private ProductMaterialDto material;

    private Long budget;

    private List<AskWorkerPhotosDto> photos;

    private UserDto user;

}
