package com.service.auth.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AccessTokenDto {

    private String token;

    public AccessTokenDto(String token) {
        this.token = token;
    }
}
