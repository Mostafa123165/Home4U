package com.service.business.dto;

import com.service.base.dto.BaseEntityDto;
import com.service.userManagement.dto.UserTypeDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter @Setter
public class BusinessDto extends BaseEntityDto<Long> {

    @NotEmpty
    @NotNull(message = "Exhibition type is required ")
    private Set<BusinessTypeDto> types;

    @NotBlank(message = "Trad name is required")
    private String tradName;

    @NotBlank(message = "The Arabic bio is required.")
    private String bioAr;

    @NotBlank(message = "The English bio is required.")
    private String bioEn;

    @NotNull(message = "businessTypes is required")
    @NotEmpty(message = "businessTypes must not empty")
    private Set<BusinessTypeDto> businessTypes;
}
