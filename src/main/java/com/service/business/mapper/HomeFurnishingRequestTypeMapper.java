package com.service.business.mapper;

import com.service.base.mapper.BaseMapper;
import com.service.business.dto.HomeFurnishingRequestTypeDto;
import com.service.business.model.HomeFurnishingRequestType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.context.i18n.LocaleContextHolder;

@Mapper(imports = {LocaleContextHolder.class})
public interface HomeFurnishingRequestTypeMapper extends BaseMapper<HomeFurnishingRequestType, HomeFurnishingRequestTypeDto> {

    @Override
    @Mappings(
            @Mapping(target = "name", expression = "java(LocaleContextHolder.getLocale().getLanguage().equals(\"ar\") ? t.getNameAr() : t.getNameEn())")
    )
    HomeFurnishingRequestTypeDto map(HomeFurnishingRequestType t);
}
