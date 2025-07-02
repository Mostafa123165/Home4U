package com.service.freelancer.dto;

import com.service.base.dto.BaseEntityDto;
import com.service.userManagement.dto.UserDto;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RequestSelectCustomPackageDto extends BaseEntityDto<Long> {


    private UserDto user;

    private SelectCustomPackageDto selectCustomPackage;

    @NotNull
    private String comment;

    private Boolean isAccepted;
    private Boolean isFinished;
    private Boolean isRejected;
}
