package com.service.business.mapper;

import com.service.base.mapper.BaseMapper;
import com.service.business.dto.OrderDto;
import com.service.business.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.context.i18n.LocaleContextHolder;

@Mapper(imports = {LocaleContextHolder.class},uses = {OrderDetailsMapper.class})
public interface OrderMapper extends BaseMapper<Order, OrderDto> {

    @Override
    @Mappings(
            @Mapping(target = "user.id", source = "userId")
    )
    Order unMap(OrderDto orderDto);


    @Override
    @Mappings(
            @Mapping(target = "userId", source = "user.id")
    )
    OrderDto map(Order order);
}
