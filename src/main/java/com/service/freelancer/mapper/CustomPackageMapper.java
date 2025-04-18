package com.service.freelancer.mapper;

import com.service.base.mapper.BaseMapper;
import com.service.freelancer.dto.CustomPackageDto;
import com.service.freelancer.model.CustomPackage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.List;

@Mapper(componentModel = "spring",imports = {LocaleContextHolder.class})
public interface CustomPackageMapper extends BaseMapper<CustomPackage, CustomPackageDto> {

    @Override
    @Mappings({
            @Mapping(target = "name", expression = "java(LocaleContextHolder.getLocale().getLanguage().equals(\"ar\") ? t.getNameAr() : t.getNameEn())"),
            @Mapping(target = "details", expression = "java(LocaleContextHolder.getLocale().getLanguage().equals(\"ar\") ? t.getDetailsAr() : t.getDetailsEn())")

    })
    CustomPackageDto map(CustomPackage t);
    List<CustomPackageDto> map(List<CustomPackage> t);
}
