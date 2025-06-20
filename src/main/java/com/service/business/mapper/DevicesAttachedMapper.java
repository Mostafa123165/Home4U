package com.service.business.mapper;

import com.service.base.mapper.BaseMapper;
import com.service.business.dto.DevicesAttachedDto;
import com.service.business.model.DevicesAttached;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.context.i18n.LocaleContextHolder;

@Mapper(imports = {LocaleContextHolder.class})
public interface DevicesAttachedMapper extends BaseMapper<DevicesAttached, DevicesAttachedDto> {

    @Override
    @Mappings(
            @Mapping(target = "name", expression = "java(LocaleContextHolder.getLocale().getLanguage().equals(\"ar\") ? t.getNameAr() : t.getNameEn())")
    )
    DevicesAttachedDto map(DevicesAttached t);
}

