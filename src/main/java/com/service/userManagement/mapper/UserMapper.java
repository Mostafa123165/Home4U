package com.service.userManagement.mapper;

import com.service.auth.model.RegisterRequestDto;
import com.service.base.mapper.BaseMapper;
import com.service.userManagement.dto.UserDto;
import com.service.userManagement.model.User;
import org.mapstruct.Mapper;

@Mapper(uses = {UserTypeMapper.class})
public interface UserMapper extends BaseMapper<User, UserDto> {

    User unMapRegister(RegisterRequestDto t);
}
