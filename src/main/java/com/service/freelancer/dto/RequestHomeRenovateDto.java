package com.service.freelancer.dto;

import com.service.base.dto.BaseEntityDto;
import com.service.common.dto.SimpleDto;
import com.service.userManagement.dto.UserDto;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RequestHomeRenovateDto extends BaseEntityDto<Long> {

    private UserDto user;

    private SimpleDto homeRenovate;

    @NotNull
    private String comment;

    private Boolean isAccepted;
    private Boolean isFinished;
    private Boolean isRejected;
}
