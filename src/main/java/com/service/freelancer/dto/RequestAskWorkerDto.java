package com.service.freelancer.dto;

import com.service.base.dto.BaseEntityDto;
import com.service.userManagement.dto.UserDto;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Setter
@Getter
public class RequestAskWorkerDto extends BaseEntityDto<Long> {

    private UserDto user;

    private AskWorkerDto askWorker;

    @NonNull
    private String comment;

    private Boolean isAccepted;
    private Boolean isFinished;
    private Boolean isRejected;
}
