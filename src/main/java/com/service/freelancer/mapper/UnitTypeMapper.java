package com.service.freelancer.mapper;

import com.service.base.mapper.BaseMapper;
import com.service.freelancer.dto.UnitTypeDto;
import com.service.freelancer.model.UnitType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.context.i18n.LocaleContextHolder;

@Mapper(componentModel = "spring",imports = {LocaleContextHolder.class })
public interface UnitTypeMapper extends BaseMapper<UnitType, UnitTypeDto> {
    @Override
    @Mappings({
            @Mapping(target = "name", expression = "java(LocaleContextHolder.getLocale().getLanguage().equals(\"ar\") ? t.getNameAr() : t.getNameEn())")
    })
    UnitTypeDto map(UnitType t);
}