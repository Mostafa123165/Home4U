package com.service.userManagement.mapper;

import com.service.auth.model.UserRegisterDto;
import com.service.base.mapper.BaseMapper;
import com.service.common.mapper.CityMapper;
import com.service.common.mapper.GovernorateMapper;
import com.service.userManagement.dto.UserDto;
import com.service.userManagement.model.User;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(uses = {UserTypeMapper.class, CityMapper.class, GovernorateMapper.class})
public interface UserMapper extends BaseMapper<User, UserDto> {

    User unMapRegister(UserRegisterDto t);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User UpdateMap(UserRegisterDto user,@MappingTarget User user1);
}
