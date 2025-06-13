package com.service.business.mapper;

import com.service.base.mapper.BaseMapper;
import com.service.business.dto.OrderSimpleDto;
import com.service.business.model.Order;
import org.mapstruct.Mapper;

@Mapper(uses = {OrderStatusMapper.class})
public interface OrderSimpleMapper extends BaseMapper<Order, OrderSimpleDto> {

}
