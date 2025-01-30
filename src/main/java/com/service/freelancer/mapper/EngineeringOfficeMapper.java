package com.service.freelancer.mapper;

import com.service.base.mapper.BaseMapper;
import com.service.freelancer.dto.EngineeringOfficeDto;
import com.service.freelancer.model.EngineeringOffice;
import com.service.userManagement.mapper.UserMapper;
import org.mapstruct.Mapper;
import org.springframework.context.i18n.LocaleContextHolder;

@Mapper(imports = {LocaleContextHolder.class} ,
        uses = {EngineeringOfficeFieldMapper.class,EngineeringOfficeDepartmentMapper.class, UserMapper.class})
public interface EngineeringOfficeMapper extends BaseMapper<EngineeringOffice, EngineeringOfficeDto> {
}
