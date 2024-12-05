package com.service.userManagement.dto;

import com.service.base.dto.BaseEntityDto;
import com.service.common.dto.CityDto;
import com.service.common.dto.GovernorateDto;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserDto extends BaseEntityDto<Long> {

    private String username;
    private String email;
    private String phone;
    private UserTypeDto userType;
    private GovernorateDto governorate;
    private CityDto city;

}
