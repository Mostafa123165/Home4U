package com.service.freelancer.mapper;

import com.service.base.mapper.BaseMapper;
import com.service.common.mapper.CityMapper;
import com.service.common.mapper.GovernorateMapper;
import com.service.freelancer.dto.AskEngineerDto;
import com.service.freelancer.model.AskEngineer;
import com.service.freelancer.model.AskEngineerPhotos;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.List;

@Mapper(imports = {LocaleContextHolder.class},
        uses = {UnitTypeMapper.class, EngineerTypeMapper.class, UrgencyLevelMapper.class,
                CityMapper.class, GovernorateMapper.class, AskEngineerPhotosMapper.class})
public interface AskEngineerMapper extends BaseMapper<AskEngineer, AskEngineerDto> {

}
