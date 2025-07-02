package com.service.freelancer.mapper;

import com.service.base.mapper.BaseMapper;
import com.service.freelancer.dto.RequestAskEngineerDto;
import com.service.freelancer.model.RequestAskEngineer;
import com.service.userManagement.mapper.UserMapper;
import org.mapstruct.Mapper;
import org.springframework.context.i18n.LocaleContextHolder;

@Mapper(imports = {LocaleContextHolder.class},
        uses = {UserMapper.class, AskEngineerMapper.class})
public interface RequestAskEngineerMapper extends BaseMapper<RequestAskEngineer, RequestAskEngineerDto> {

}