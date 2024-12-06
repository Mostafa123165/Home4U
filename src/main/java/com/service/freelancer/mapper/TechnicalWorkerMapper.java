package com.service.freelancer.mapper;

import com.service.base.mapper.BaseMapper;
import com.service.freelancer.dto.TechnicalWorkerDto;
import com.service.freelancer.model.TechnicalWorker;
import com.service.userManagement.mapper.UserMapper;
import org.mapstruct.Mapper;
import org.springframework.context.i18n.LocaleContextHolder;

@Mapper(componentModel = "spring",imports = {LocaleContextHolder.class , UserMapper.class,TechnicalWorkerServMapper.class,TechnicalWorkerTypeMapper.class})
public interface TechnicalWorkerMapper extends BaseMapper<TechnicalWorker, TechnicalWorkerDto> {
}
