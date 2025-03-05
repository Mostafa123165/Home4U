package com.service.business.mapper;

import com.service.auth.model.UserRegisterDto;
import com.service.base.mapper.BaseMapper;
import com.service.business.dto.BusinessDto;
import com.service.business.dto.BusinessLoginDto;
import com.service.business.dto.BusinessTypeDto;
import com.service.business.model.Business;
import com.service.userManagement.mapper.UserTypeMapper;
import com.service.userManagement.model.UserType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(uses = {UserTypeMapper.class,BusinessMapper.class, UserTypeMapper.class})
public interface BusinessMapper extends BaseMapper<Business, BusinessDto> {


    @Mappings({
            @Mapping(target = "userType",source = "t.userType"),
            @Mapping(target = "tradName",source = "t.business.tradName"),
            @Mapping(target = "bioAr",source = "t.business.bioAr"),
            @Mapping(target = "bioEn",source = "t.business.bioEn"),
    })
    Business unMapUserRegister(UserRegisterDto t);

    @Mappings({
            @Mapping(target = "businessId", source = "t.id"),
    })
    BusinessLoginDto mapToBusinessLoginDto(Business t);
}
