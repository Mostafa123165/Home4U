package com.service.userManagement.dto;

import com.service.base.dto.BaseEntityDto;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserDto extends BaseEntityDto<Long> {

    private String username;
    private String email;
    private String phone;
    private UserTypeDto userType;

}
