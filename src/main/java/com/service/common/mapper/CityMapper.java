package com.service.common.mapper;

import com.service.base.mapper.BaseMapper;
import com.service.common.dto.CityDto;
import com.service.common.model.City;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.context.i18n.LocaleContextHolder;

@Mapper(imports = {LocaleContextHolder.class})
public interface CityMapper extends BaseMapper<City, CityDto> {

    @Override
    @Mappings({
            @Mapping(target = "name", expression = "java(LocaleContextHolder.getLocale().getLanguage() == \"ar\" ? t.getNameAr() : t.getNameEn())"),
    })
    CityDto map(City t);
}
