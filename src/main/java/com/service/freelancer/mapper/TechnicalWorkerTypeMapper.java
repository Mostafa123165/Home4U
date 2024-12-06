package com.service.freelancer.mapper;

import com.service.base.mapper.BaseMapper;
import com.service.freelancer.dto.EngineerDto;
import com.service.freelancer.dto.TechnicalWorkerTypeDto;
import com.service.freelancer.model.Engineer;
import com.service.freelancer.model.TechnicalWorkerType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.context.i18n.LocaleContextHolder;

@Mapper(componentModel = "spring",imports = {LocaleContextHolder.class })
public interface TechnicalWorkerTypeMapper extends BaseMapper<TechnicalWorkerType, TechnicalWorkerTypeDto> {
    @Override
    @Mappings({
            @Mapping(target = "name", expression = "java(LocaleContextHolder.getLocale().getLanguage().equals(\"ar\") ? t.getNameAr() : t.getNameEn())")
    })
    TechnicalWorkerTypeDto map(TechnicalWorkerType t);
}
