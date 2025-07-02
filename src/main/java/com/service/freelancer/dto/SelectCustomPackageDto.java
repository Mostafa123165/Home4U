package com.service.freelancer.dto;

import com.service.base.dto.BaseEntityDto;
import com.service.userManagement.dto.UserDto;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Formula;

@Setter
@Getter
public class SelectCustomPackageDto extends BaseEntityDto<Long> {

    private String phoneNumber;

    private Boolean isInsideCompound;

    private UnitTypeDto unitType;

    private CustomPackageDto customPackage;

    private UserDto user;

    private Long requestCount;

    private String askStatus;
}
