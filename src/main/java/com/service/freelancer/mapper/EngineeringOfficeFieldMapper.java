package com.service.freelancer.mapper;

import com.service.base.mapper.BaseMapper;
import com.service.freelancer.dto.EngineeringOfficeFieldDto;
import com.service.freelancer.model.EngineeringOfficeField;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.List;

@Mapper(componentModel = "spring",imports = {LocaleContextHolder.class })
public interface EngineeringOfficeFieldMapper extends BaseMapper<EngineeringOfficeField, EngineeringOfficeFieldDto> {

    @Override
    @Mappings({
            @Mapping(target = "name", expression = "java(LocaleContextHolder.getLocale().getLanguage().equals(\"ar\") ? t.getNameAr() : t.getNameEn())")
    })
    EngineeringOfficeFieldDto map(EngineeringOfficeField t);
    List<EngineeringOfficeFieldDto> map(List<EngineeringOfficeField> t);

}
