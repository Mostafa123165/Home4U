package com.service.freelancer.mapper;

import com.service.base.mapper.BaseMapper;
import com.service.common.mapper.CityMapper;
import com.service.common.mapper.GovernorateMapper;
import com.service.freelancer.dto.TechnicalWorkerDto;
import com.service.freelancer.model.TechnicalWorker;
import com.service.userManagement.mapper.UserMapper;
import com.service.userManagement.mapper.UserTypeMapper;
import org.mapstruct.Mapper;
import org.springframework.context.i18n.LocaleContextHolder;

@Mapper(imports = {LocaleContextHolder.class} ,
         uses = { UserMapper.class,TechnicalWorkerServMapper.class,TechnicalWorkerTypeMapper.class
                 ,UserTypeMapper.class, CityMapper.class, GovernorateMapper.class})
public interface TechnicalWorkerMapper extends BaseMapper<TechnicalWorker, TechnicalWorkerDto> {
}
