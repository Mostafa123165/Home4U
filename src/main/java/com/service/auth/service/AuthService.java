package com.service.auth.service;


import com.service.auth.jwt.JwtGenerator;
import com.service.auth.model.LoginRequestDto;
import com.service.auth.model.LoginResponseDto;
import com.service.auth.model.RegisterRequestDto;
import com.service.base.Constant;
import com.service.common.service.MessageSourceService;
import com.service.error.BadRequestException;
import com.service.userManagement.mapper.UserMapper;
import com.service.userManagement.model.User;
import com.service.userManagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserService userService;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final MessageSourceService messageSourceService;
    private final JwtGenerator jetGenerator;
    private final AuthenticationManager authenticationManager;


    public String register(RegisterRequestDto registerRequest) {

        validateRegisterRequest(registerRequest.getEmail(), registerRequest.getPhone());

        registerRequest.setPassword(hashingPassword(registerRequest.getPassword()));
        User user = userMapper.unMapRegister(registerRequest);
      //  user.setCreatedDate(LocalDateTime.now());
       // user.setModifiedDate(LocalDateTime.now());
        if(user.getUserType().getCode().equals(Constant.UserTypeEnum.GENERAL_USER.name())) {
             userService.insert(user);
        }
        else if(registerRequest.getUserType().getCode().equals(Constant.UserTypeEnum.ENGINEER.name())) {
        }
        else{
        }

        return messageSourceService.getMessage("success.user.registered");
    }

    private void validateRegisterRequest(String email,String phone) {
        if(email==null && phone==null) {
            throw new BadRequestException("Either email or phone must be provided. Please provide at least one contact method.");
        }
        else if(userService.getByEmail(email).isPresent()) {
           throw new BadRequestException(messageSourceService.getMessage("validation.email.in_use"));
        }
        else if(userService.getByPhone(phone).isPresent()) {
           throw new BadRequestException(messageSourceService.getMessage("validation.phone.in_use"));
        }
    }

    private String hashingPassword(String password) {
        return passwordEncoder.encode(password);
    }

    public LoginResponseDto login(LoginRequestDto request) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(request.getEmailOrPhone(), request.getPassword());
        Authentication authenticated = authenticationManager.authenticate(authentication);

        User user = (User)authenticated.getPrincipal();

        String token = jetGenerator.generateToken(user.getId(),false);
        String refreshToken = jetGenerator.generateToken(user.getId(),true);

        return LoginResponseDto
                .builder()
                .token(token)
                .refreshToken(refreshToken)
                .user(userMapper.map(user))
                .build();
    }

}
