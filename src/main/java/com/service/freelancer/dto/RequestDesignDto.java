package com.service.freelancer.dto;

import com.service.base.dto.BaseEntityDto;
import com.service.common.dto.GovernorateDto;
import com.service.userManagement.dto.UserDto;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RequestDesignDto extends BaseEntityDto<Long> {

    private String phoneNumber;

    private UnitTypeDto unitType;

    private GovernorateDto governorate;

    private Long unitArea;

    private Long budget;

    private Long requiredDuration;

    private String notes;

    private UserDto user;

    private Long requestCount;

    private String askStatus;

}
