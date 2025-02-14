package com.service.business.mapper;

import com.service.auth.model.UserRegisterDto;
import com.service.base.mapper.BaseMapper;
import com.service.business.dto.BusinessDto;
import com.service.business.model.Business;
import com.service.userManagement.mapper.UserTypeMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(uses = {UserTypeMapper.class,BusinessMapper.class})
public interface BusinessMapper extends BaseMapper<Business, BusinessDto> {


    @Mappings({
            @Mapping(target = "userType",source = "t.userType"),
            @Mapping(target = "tradName",source = "t.business.tradName"),
            @Mapping(target = "bioAr",source = "t.business.bioAr"),
            @Mapping(target = "bioEn",source = "t.business.bioEn"),
    })
    Business unMapUserRegister(UserRegisterDto t);
}
