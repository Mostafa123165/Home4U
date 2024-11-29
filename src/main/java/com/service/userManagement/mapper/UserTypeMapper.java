package com.service.userManagement.mapper;

import com.service.base.mapper.BaseMapper;
import com.service.userManagement.dto.UserTypeDto;
import com.service.userManagement.model.UserType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.context.i18n.LocaleContextHolder;

@Mapper(imports = {LocaleContextHolder.class})
public interface UserTypeMapper extends BaseMapper<UserType, UserTypeDto> {

    @Override
    @Mappings({
            @Mapping(target = "name", expression = "java(LocaleContextHolder.getLocale().getLanguage() == \"ar\" ? t.getNameAr() : t.getNameEn())"),
    })
    UserTypeDto map(UserType t);
}
