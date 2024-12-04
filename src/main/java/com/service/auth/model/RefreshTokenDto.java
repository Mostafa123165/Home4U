package com.service.auth.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RefreshTokenDto {

    @NotBlank(message = "refreshToken is required")
    private String refreshToken;

}
