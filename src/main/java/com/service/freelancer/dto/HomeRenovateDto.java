package com.service.freelancer.dto;

import com.service.base.dto.BaseEntityDto;
import com.service.common.dto.CityDto;
import com.service.common.dto.GovernorateDto;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class HomeRenovateDto extends BaseEntityDto<Long> {

    private String phoneNumber;

    private Boolean isInsideCompound;

    private UnitTypeDto unitType;

    private UnitStatusesDto unitStatuses;

    private UnitWorkTypesDto unitWorkTypes;

    private WorkSkillsDto workSkills;

    private CityDto city;

    private GovernorateDto governorate;

    private Long unitArea;

    private Long budget;

    private Long region;

    private Long numberOfRooms;

    private Long numberOfBathrooms;

    private Long requiredDuration;

    private String notes;

}
