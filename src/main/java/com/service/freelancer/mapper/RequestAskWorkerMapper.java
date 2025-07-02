package com.service.freelancer.mapper;

import com.service.base.mapper.BaseMapper;
import com.service.freelancer.dto.RequestAskWorkerDto;
import com.service.freelancer.model.RequestAskWorker;
import com.service.userManagement.mapper.UserMapper;
import org.mapstruct.Mapper;
import org.springframework.context.i18n.LocaleContextHolder;

@Mapper(imports = {LocaleContextHolder.class},
        uses = {UserMapper.class, AskWorkerMapper.class})
public interface RequestAskWorkerMapper extends BaseMapper<RequestAskWorker, RequestAskWorkerDto> {

}