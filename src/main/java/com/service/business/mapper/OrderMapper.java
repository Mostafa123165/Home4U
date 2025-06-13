package com.service.business.mapper;

import com.service.base.mapper.BaseMapper;
import com.service.business.dto.OrderDto;
import com.service.business.dto.OrderSimpleDto;
import com.service.business.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(uses = {OrderStatusMapper.class,OrderStatusMapper.class,OrderDetailsMapper.class})
public interface OrderMapper extends BaseMapper<Order, OrderDto> {

    @Override
    @Mappings({
        @Mapping(target = "userId", source = "user.id")
    })
    OrderDto map(Order order);

    @Mappings({
        @Mapping(target = "quantity", expression = "java(t.getOrderDetails().stream().mapToDouble(detail -> detail.getAmount()).sum())"),
        @Mapping(target = "price", expression = "java(t.getOrderDetails().stream().mapToDouble(detail -> detail.getAmount() * detail.getProduct().getPrice()).sum())"),
    })
    OrderSimpleDto mapToSimple(Order t);

    List<OrderSimpleDto> mapToSimple(List<Order> t);


}
