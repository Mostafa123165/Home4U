package com.service.auth.model;

import com.service.common.dto.CityDto;
import com.service.common.dto.GovernorateDto;
import com.service.common.model.Governorate;
import com.service.userManagement.dto.UserTypeDto;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserRegisterDto {

    @NotBlank(message = "first name cannot be blank")
    private String firstName;

    @NotBlank(message = "first name cannot be blank")
    private String lastName;

    @Email(message = "Please provide a valid email address (e.g., user@example.com).")
    @NotBlank(message = "email cannot be blank")
    private String email;

    @Size(max = 11,message = "Phone number length must be equal 11")
    private String phone;

    @Min(value = 8, message = "Password must be at least 8 characters.")
    private String password;

    @NotNull(message = "user type cannot be blank")
    private UserTypeDto userType;

    private GovernorateDto governorate;

    private CityDto city;

}
