package com.service.business.mapper;

import com.service.base.mapper.BaseMapper;
import com.service.business.dto.OrderDetailsDto;
import com.service.business.model.OrderDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.context.i18n.LocaleContextHolder;

@Mapper(imports = {LocaleContextHolder.class})
public interface OrderDetailsMapper extends BaseMapper<OrderDetails, OrderDetailsDto> {

    @Override
    @Mappings({
            @Mapping(target = "productId" ,source = "product.id"),
    })
    OrderDetailsDto map(OrderDetails t);

    @Override
    @Mappings({
            @Mapping(target = "product.id",source = "productId"),
    })
    OrderDetails unMap(OrderDetailsDto t);
}
