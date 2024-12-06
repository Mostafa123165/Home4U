package com.service.freelancer.dto;

import com.service.base.dto.BaseEntityDto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class EngineerDto extends BaseEntityDto<Long> {

    @NotNull
    private EngineerTypeDto type;

    @NotNull
    private int yearsOfExperience;

    @NotEmpty
    @NotNull
    private List<EngineerServDto> engineerServ;
}
