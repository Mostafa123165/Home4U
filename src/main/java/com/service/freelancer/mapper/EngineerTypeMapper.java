package com.service.freelancer.mapper;

import com.service.base.mapper.BaseMapper;
import com.service.freelancer.dto.EngineerTypeDto;
import com.service.freelancer.model.EngineerType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.List;

@Mapper(componentModel = "spring",imports = {LocaleContextHolder.class})
public interface EngineerTypeMapper extends BaseMapper<EngineerType, EngineerTypeDto> {
    @Override
    @Mappings({
            @Mapping(target = "name", expression = "java(LocaleContextHolder.getLocale().getLanguage().equals(\"ar\") ? t.getNameAr() : t.getNameEn())")
    })
    EngineerTypeDto map(EngineerType t);
    List<EngineerTypeDto> map(List<EngineerType> t);

}
