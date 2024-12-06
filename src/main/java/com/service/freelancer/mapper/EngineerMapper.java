package com.service.freelancer.mapper;

import com.service.base.mapper.BaseMapper;
import com.service.freelancer.dto.EngineerDto;
import com.service.freelancer.model.Engineer;
import com.service.userManagement.mapper.UserMapper;
import org.mapstruct.Mapper;
import org.springframework.context.i18n.LocaleContextHolder;

@Mapper(componentModel = "spring",imports = {LocaleContextHolder.class , UserMapper.class,EngineerServMapper.class,EngineerTypeMapper.class})
public interface EngineerMapper extends BaseMapper<Engineer, EngineerDto> {

    @Override
    Engineer unMap(EngineerDto engineerDto);
}
