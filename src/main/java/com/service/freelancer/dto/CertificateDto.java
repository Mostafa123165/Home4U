package com.service.freelancer.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.service.base.dto.BaseEntityDto;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class CertificateDto extends BaseEntityDto<Long> {

    @NotNull
    private String name;

    private String description;

    private String path;
}
