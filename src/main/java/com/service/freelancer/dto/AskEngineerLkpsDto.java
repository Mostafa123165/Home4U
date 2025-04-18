package com.service.freelancer.dto;

import com.service.common.dto.GovernorateDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class AskEngineerLkpsDto {

    private List<EngineerTypeDto> engineerType;

    private List<UnitTypeDto> unitType;

    private List<GovernorateDto> governorate;

    private List<UrgencyLevelDto> urgencyLevel;
}
