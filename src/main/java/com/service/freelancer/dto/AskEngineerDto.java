package com.service.freelancer.dto;

import com.service.base.dto.BaseEntityDto;
import com.service.common.dto.CityDto;
import com.service.common.dto.GovernorateDto;
import com.service.userManagement.dto.UserDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class AskEngineerDto extends BaseEntityDto<Long> {

    private String phoneNumber;

    private String projectName;

    private String projectDescription;

    private EngineerTypeDto engineerType;


    private UnitTypeDto unitType;

    private Long budget;

    private CityDto city;

    private GovernorateDto governorate;

    private UrgencyLevelDto urgencyLevel;

    private String deadline;

    private List<AskEngineerPhotosDto> photos;

    private UserDto user;

}
