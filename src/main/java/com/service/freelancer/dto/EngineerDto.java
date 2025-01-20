package com.service.freelancer.dto;

import com.service.auth.model.UserRegisterDto;
import com.service.base.dto.BaseEntityDto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class EngineerDto extends BaseEntityDto<Long> {

    private UserRegisterDto user;

    @NotNull
    private EngineerTypeDto type;

    @NotNull
    private int yearsOfExperience;

    @NotEmpty
    @NotNull
    private List<EngineerServDto> engineerServ;

    private String bio;

    @NotNull
    private String linkedin;

    private String behance;
}
