package com.service.freelancer.mapper;

import com.service.base.mapper.BaseMapper;
import com.service.common.dto.SimpleDto;
import com.service.common.mapper.CityMapper;
import com.service.common.mapper.GovernorateMapper;
import com.service.freelancer.dto.EngineeringOfficeDto;
import com.service.freelancer.model.EngineeringOffice;
import com.service.userManagement.mapper.UserMapper;
import com.service.userManagement.mapper.UserTypeMapper;
import org.mapstruct.Mapper;
import org.springframework.context.i18n.LocaleContextHolder;

@Mapper(imports = {LocaleContextHolder.class} ,
        uses = {EngineeringOfficeFieldMapper.class,EngineeringOfficeDepartmentMapper.class, UserMapper.class,
                UserTypeMapper.class, CityMapper.class, GovernorateMapper.class})
public interface EngineeringOfficeMapper extends BaseMapper<EngineeringOffice, EngineeringOfficeDto> {
    EngineeringOffice unMapSimple(SimpleDto dto);
}
