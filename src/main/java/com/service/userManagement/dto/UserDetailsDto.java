package com.service.userManagement.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDetailsDto {
    private String username;
    private String password;
    private String phoneNumber;
}
