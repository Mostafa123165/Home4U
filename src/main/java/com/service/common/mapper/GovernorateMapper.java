package com.service.common.mapper;

import com.service.base.mapper.BaseMapper;
import com.service.common.dto.CityDto;
import com.service.common.dto.GovernorateDto;
import com.service.common.model.City;
import com.service.common.model.Governorate;
import com.service.userManagement.dto.UserTypeDto;
import com.service.userManagement.model.UserType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.context.i18n.LocaleContextHolder;

@Mapper(imports = {LocaleContextHolder.class})
public interface GovernorateMapper extends BaseMapper<Governorate, GovernorateDto> {
    @Override
    @Mappings({
            @Mapping(target = "name", expression = "java(LocaleContextHolder.getLocale().getLanguage() == \"ar\" ? t.getNameAr() : t.getNameEn())"),
    })
    GovernorateDto map(Governorate t);
}
