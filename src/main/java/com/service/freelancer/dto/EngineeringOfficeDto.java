package com.service.freelancer.dto;

import com.service.auth.model.UserRegisterDto;
import com.service.base.dto.BaseEntityDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class EngineeringOfficeDto extends BaseEntityDto<Long> {

    private UserRegisterDto user;

    private String tradeName;

    private String description;

    private String commercialRegisterPath;

    private String taxCardPath;

    private String personalCardPath;

    private EngineeringOfficeFieldDto engineeringOfficeField;

    private List<EngineeringOfficeDepartmentDto> engineerServ;
}
