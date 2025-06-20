package com.service.business.mapper;

import com.service.base.mapper.BaseMapper;
import com.service.business.dto.HomeFurnishingRequestDto;
import com.service.business.model.HomeFurnishingRequest;
import com.service.common.mapper.GovernorateMapper;
import org.mapstruct.Mapper;
import org.springframework.context.i18n.LocaleContextHolder;

@Mapper(imports = {LocaleContextHolder.class},uses = {FurnitureTypeMapper.class, DevicesAttachedMapper.class,
        KitchenTypeMapper.class, ProductMaterialMapper.class, GovernorateMapper.class, HomeFurnishingRequestTypeMapper.class})
public interface HomeFurnishingRequestMapper extends BaseMapper<HomeFurnishingRequest, HomeFurnishingRequestDto> {


}
