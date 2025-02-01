package com.service.retail.dto;

import com.service.base.dto.BaseEntityDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter @Setter
public class ExhibitionDto extends BaseEntityDto<Long> {

    @NotEmpty
    @NotNull(message = "Exhibition type is required ")
    private Set<ExhibitionTypeDto> types;

    @NotBlank(message = "Trad name is required")
    private String tradName;

    @NotBlank(message = "The Arabic bio is required.")
    private String bioAr;

    @NotBlank(message = "The English bio is required.")
    private String bioEn;
}
