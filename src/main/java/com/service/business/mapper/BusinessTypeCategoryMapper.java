package com.service.business.mapper;

import com.service.base.mapper.BaseMapper;
import com.service.business.dto.BusinessTypeCategoryDto;
import com.service.business.model.BusinessType;
import com.service.business.model.BusinessTypeCategory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.context.i18n.LocaleContextHolder;

@Mapper(imports = {LocaleContextHolder.class},uses = {BusinessTypeMapper.class})
public interface BusinessTypeCategoryMapper extends BaseMapper<BusinessTypeCategory, BusinessTypeCategoryDto> {

    @Override
    @Mappings({
            @Mapping(target = "name", expression = "java(LocaleContextHolder.getLocale().getLanguage().equals(\"ar\") ? t.getNameAr() : t.getNameEn())"),
    })
    BusinessTypeCategoryDto map(BusinessTypeCategory t);
}
