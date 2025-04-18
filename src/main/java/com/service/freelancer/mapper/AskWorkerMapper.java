package com.service.freelancer.mapper;

import com.service.base.mapper.BaseMapper;
import com.service.business.mapper.ProductMaterialMapper;
import com.service.common.mapper.CityMapper;
import com.service.common.mapper.GovernorateMapper;
import com.service.freelancer.dto.AskWorkerDto;
import com.service.freelancer.model.AskWorker;
import org.mapstruct.Mapper;
import org.springframework.context.i18n.LocaleContextHolder;

@Mapper(imports = {LocaleContextHolder.class},
        uses = {UnitTypeMapper.class, TechnicalWorkerTypeMapper.class, ProductMaterialMapper.class,
                CityMapper.class, GovernorateMapper.class, AskWorkerPhotosMapper.class})
public interface AskWorkerMapper extends BaseMapper<AskWorker, AskWorkerDto> {
}
