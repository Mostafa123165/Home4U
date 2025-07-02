package com.service.freelancer.mapper;

import com.service.base.mapper.BaseMapper;
import com.service.freelancer.dto.RequestSelectCustomPackageDto;
import com.service.freelancer.model.RequestSelectCustomPackage;
import com.service.userManagement.mapper.UserMapper;
import org.mapstruct.Mapper;
import org.springframework.context.i18n.LocaleContextHolder;

@Mapper(imports = {LocaleContextHolder.class},
        uses = {UserMapper.class, SelectCustomPackageMapper.class})
public interface RequestSelectCustomPackageMapper extends BaseMapper<RequestSelectCustomPackage, RequestSelectCustomPackageDto> {

}