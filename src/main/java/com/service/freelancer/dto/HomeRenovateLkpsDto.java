package com.service.freelancer.dto;

import com.service.common.dto.CityDto;
import com.service.common.dto.GovernorateDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class HomeRenovateLkpsDto {
    List<UnitTypeDto> unitTypes;
    List<UnitStatusesDto> unitStatuses;
    List<UnitWorkTypesDto> unitWorkTypes;
    List<WorkSkillsDto> workSkills;
    List<GovernorateDto> governorates;
}
