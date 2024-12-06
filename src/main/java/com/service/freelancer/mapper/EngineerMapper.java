package com.service.freelancer.mapper;

import com.service.base.mapper.BaseMapper;
import com.service.freelancer.dto.EngineerDto;
import com.service.freelancer.model.Engineer;
import com.service.userManagement.mapper.UserMapper;
import org.mapstruct.Mapper;
import org.springframework.context.i18n.LocaleContextHolder;

@Mapper(imports = {LocaleContextHolder.class} ,
        uses = {EngineerServMapper.class,EngineerTypeMapper.class,UserMapper.class})
public interface EngineerMapper extends BaseMapper<Engineer, EngineerDto> {

}
