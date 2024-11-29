package com.service.base.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public abstract class BaseResponse {
    private Boolean success;
    private Integer status;

    public BaseResponse(Integer status, Boolean success) {
        this.status = status;
        this.success = success;
    }
}
