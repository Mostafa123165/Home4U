package com.service.freelancer.mapper;

import com.service.base.mapper.BaseMapper;
import com.service.common.mapper.GovernorateMapper;
import com.service.freelancer.dto.RequestDesignDto;
import com.service.freelancer.model.RequestDesign;
import org.mapstruct.Mapper;
import org.springframework.context.i18n.LocaleContextHolder;

@Mapper(imports = {LocaleContextHolder.class},
        uses = {UnitTypeMapper.class, GovernorateMapper.class})
public interface RequestDesignMapper extends BaseMapper<RequestDesign, RequestDesignDto> {
}
