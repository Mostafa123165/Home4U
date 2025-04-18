package com.service.freelancer.mapper;

import com.service.base.mapper.BaseMapper;
import com.service.freelancer.dto.UrgencyLevelDto;
import com.service.freelancer.model.UrgencyLevel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.context.i18n.LocaleContextHolder;

@Mapper(componentModel = "spring", imports = {LocaleContextHolder.class})
public interface UrgencyLevelMapper extends BaseMapper<UrgencyLevel, UrgencyLevelDto> {
    @Override
    @Mappings({
            @Mapping(target = "name", expression = "java(LocaleContextHolder.getLocale().getLanguage().equals(\"ar\") ? t.getNameAr() : t.getNameEn())")
    })
    UrgencyLevelDto map(UrgencyLevel t);
}