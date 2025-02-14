package com.service.business.mapper;

import com.service.base.mapper.BaseMapper;
import com.service.business.dto.BusinessTypeDto;
import com.service.business.model.BusinessType;
import com.service.userManagement.mapper.UserTypeMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.context.i18n.LocaleContextHolder;

@Mapper(imports = {LocaleContextHolder.class},uses = {UserTypeMapper.class})
public interface BusinessTypeMapper extends BaseMapper<BusinessType, BusinessTypeDto> {

    @Override
    @Mappings(
            @Mapping(target = "name", expression = "java(LocaleContextHolder.getLocale().getLanguage().equals(\"ar\") ? t.getNameAr() : t.getNameEn())")
    )
    BusinessTypeDto map(BusinessType t);
}
