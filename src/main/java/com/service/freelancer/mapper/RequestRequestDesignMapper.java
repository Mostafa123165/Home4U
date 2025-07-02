package com.service.freelancer.mapper;

import com.service.base.mapper.BaseMapper;
import com.service.freelancer.dto.RequestRequestDesignDto;
import com.service.freelancer.model.RequestRequestDesign;
import com.service.userManagement.mapper.UserMapper;
import org.mapstruct.Mapper;
import org.springframework.context.i18n.LocaleContextHolder;

@Mapper(imports = {LocaleContextHolder.class},
        uses = {UserMapper.class, RequestDesignMapper.class})
public interface RequestRequestDesignMapper extends BaseMapper<RequestRequestDesign, RequestRequestDesignDto> {

}