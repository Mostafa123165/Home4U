package com.service.freelancer.dto;

import com.service.auth.model.UserRegisterDto;
import com.service.base.dto.BaseEntityDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class TechnicalWorkerDto extends BaseEntityDto<Long> {
    private UserRegisterDto user;
    private TechnicalWorkerTypeDto type;
    private int yearsOfExperience;
    private List<TechnicalWorkerServDto> workerServs;
    private String bio;
}
