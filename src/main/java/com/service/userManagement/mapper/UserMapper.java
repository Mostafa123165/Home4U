package com.service.userManagement.mapper;

import com.service.auth.model.UserRegisterDto;
import com.service.base.mapper.BaseMapper;
import com.service.common.mapper.CityMapper;
import com.service.common.mapper.GovernorateMapper;
import com.service.userManagement.dto.UserDto;
import com.service.userManagement.model.User;
import org.mapstruct.Mapper;

@Mapper(uses = {UserTypeMapper.class, GovernorateMapper.class, CityMapper.class})
public interface UserMapper extends BaseMapper<User, UserDto> {

    User unMapRegister(UserRegisterDto t);
}
