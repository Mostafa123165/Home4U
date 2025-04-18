package com.service.freelancer.mapper;

import com.service.base.mapper.BaseMapper;
import com.service.common.mapper.CityMapper;
import com.service.common.mapper.GovernorateMapper;
import com.service.freelancer.dto.HomeRenovateDto;
import com.service.freelancer.model.HomeRenovate;
import org.mapstruct.Mapper;
import org.springframework.context.i18n.LocaleContextHolder;

@Mapper(imports = {LocaleContextHolder.class},
        uses = {UnitTypeMapper.class, UnitStatusesMapper.class, UnitWorkTypesMapper.class,
                WorkSkillsMapper.class, CityMapper.class, GovernorateMapper.class})
public interface HomeRenovateMapper extends BaseMapper<HomeRenovate, HomeRenovateDto> {

}
