package com.service.freelancer.mapper;

import com.service.base.mapper.BaseMapper;
import com.service.freelancer.dto.EngineeringOfficeDepartmentDto;
import com.service.freelancer.model.EngineeringOfficeDepartment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.List;

@Mapper(componentModel = "spring",imports = {LocaleContextHolder.class})
public interface EngineeringOfficeDepartmentMapper extends BaseMapper<EngineeringOfficeDepartment, EngineeringOfficeDepartmentDto> {

    @Override
    @Mappings({
            @Mapping(target = "name", expression = "java(LocaleContextHolder.getLocale().getLanguage().equals(\"ar\") ? t.getNameAr() : t.getNameEn())")
    })
    EngineeringOfficeDepartmentDto map(EngineeringOfficeDepartment t);
    List<EngineeringOfficeDepartmentDto> map(List<EngineeringOfficeDepartment> t);

}
