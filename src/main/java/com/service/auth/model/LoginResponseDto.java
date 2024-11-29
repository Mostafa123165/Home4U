package com.service.auth.model;

import com.service.userManagement.dto.UserDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class LoginResponseDto {
    private String token;
    private String refreshToken;
    private UserDto user;
}
