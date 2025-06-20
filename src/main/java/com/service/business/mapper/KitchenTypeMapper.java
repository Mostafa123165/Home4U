package com.service.business.mapper;

import com.service.base.mapper.BaseMapper;
import com.service.business.dto.KitchenTypeDto;
import com.service.business.model.KitchenType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.context.i18n.LocaleContextHolder;

@Mapper(imports = {LocaleContextHolder.class})
public interface KitchenTypeMapper extends BaseMapper<KitchenType, KitchenTypeDto> {

    @Override
    @Mappings(
            @Mapping(target = "name", expression = "java(LocaleContextHolder.getLocale().getLanguage().equals(\"ar\") ? t.getNameAr() : t.getNameEn())")
    )
    KitchenTypeDto map(KitchenType t);
}
