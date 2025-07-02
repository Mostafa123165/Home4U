package com.service.freelancer.dto;

import com.service.base.dto.BaseEntityDto;
import com.service.freelancer.model.RequestDesign;
import com.service.userManagement.model.User;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RequestRequestDesignDto extends BaseEntityDto<Long> {

    private User user;

    private RequestDesign requestDesign;

    @NotNull
    private String comment;

    private Boolean isAccepted;
    private Boolean isFinished;
    private Boolean isRejected;
}
