package com.service.freelancer.dto;

import com.service.auth.model.UserRegisterDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class EngineerDto extends UserRegisterDto {
    private EngineerTypeDto type;
    private int yearsOfExperience;
    private List<EngineerServDto> engineerServ;

}
