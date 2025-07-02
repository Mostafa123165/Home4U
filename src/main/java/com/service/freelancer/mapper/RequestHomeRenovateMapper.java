package com.service.freelancer.mapper;

import com.service.base.mapper.BaseMapper;
import com.service.freelancer.dto.RequestHomeRenovateDto;
import com.service.freelancer.model.RequestHomeRenovate;
import com.service.userManagement.mapper.UserMapper;
import org.mapstruct.Mapper;
import org.springframework.context.i18n.LocaleContextHolder;

@Mapper(imports = {LocaleContextHolder.class},
        uses = {UserMapper.class, HomeRenovateMapper.class})
public interface RequestHomeRenovateMapper extends BaseMapper<RequestHomeRenovate, RequestHomeRenovateDto> {

}
