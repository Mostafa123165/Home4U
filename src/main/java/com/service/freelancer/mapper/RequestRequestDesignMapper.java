package com.service.freelancer.mapper;

import com.service.base.mapper.BaseMapper;
import com.service.freelancer.dto.RequestRequestDesignDto;
import com.service.freelancer.model.RequestRequestDesign;
import com.service.userManagement.mapper.UserMapper;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.context.i18n.LocaleContextHolder;

@Mapper(imports = {LocaleContextHolder.class},
        uses = {UserMapper.class, RequestDesignMapper.class})
public interface RequestRequestDesignMapper extends BaseMapper<RequestRequestDesign, RequestRequestDesignDto> {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    RequestRequestDesign UpdateMap(RequestRequestDesignDto requestRequestDesignDto, @MappingTarget RequestRequestDesign requestRequestDesign);
}