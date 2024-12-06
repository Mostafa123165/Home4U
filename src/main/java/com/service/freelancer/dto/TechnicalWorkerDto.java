package com.service.freelancer.dto;

import com.service.base.dto.BaseEntityDto;
import com.service.userManagement.dto.UserDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class TechnicalWorkerDto extends BaseEntityDto<Long> {
    private UserDto user;
    private TechnicalWorkerTypeDto type;
    private int yearsOfExperience;
    private List<TechnicalWorkerServDto> workerServs;
}
