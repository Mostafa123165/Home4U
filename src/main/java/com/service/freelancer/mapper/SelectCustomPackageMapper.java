package com.service.freelancer.mapper;

import com.service.base.mapper.BaseMapper;
import com.service.freelancer.dto.SelectCustomPackageDto;
import com.service.freelancer.model.SelectCustomPackage;
import org.mapstruct.Mapper;
import org.springframework.context.i18n.LocaleContextHolder;

@Mapper(imports = {LocaleContextHolder.class},
        uses = {UnitTypeMapper.class, CustomPackageMapper.class})
public interface SelectCustomPackageMapper extends BaseMapper<SelectCustomPackage, SelectCustomPackageDto> {
}
