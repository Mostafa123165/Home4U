package com.service.business.mapper;

import com.service.base.mapper.BaseMapper;
import com.service.business.dto.OrderStatusDto;
import com.service.common.model.OrderStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.context.i18n.LocaleContextHolder;

@Mapper(imports = {LocaleContextHolder.class})
public interface OrderStatusMapper extends BaseMapper<OrderStatus, OrderStatusDto> {

    @Override
    @Mappings(
            @Mapping(target = "name", expression = "java(LocaleContextHolder.getLocale().getLanguage().equals(\"ar\") ? t.getNameAr() : t.getNameEn())")
    )
    OrderStatusDto map(OrderStatus t);
}
