package com.service.base.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
public class BaseEntityDto<ID extends Serializable> {

    @Schema(description = "The database generated ID")
    private ID id;

    @Schema(description = "The row status 1-draft , 2-confirmed , 3-approved , 4-rejected , 5-active , 6-inactive")
    private Integer statusCode;
}
