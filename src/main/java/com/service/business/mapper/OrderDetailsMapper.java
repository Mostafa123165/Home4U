package com.service.business.mapper;

import com.service.base.mapper.BaseMapper;
import com.service.business.dto.OrderDetailsDto;
import com.service.business.dto.OrderDetailsResponseDto;
import com.service.business.model.OrderDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.List;

@Mapper(imports = {LocaleContextHolder.class},uses = {ProductMapper.class})
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


    OrderDetailsResponseDto mapToResponse(OrderDetails t) ;

    List<OrderDetailsResponseDto> mapToResponse(List<OrderDetails> t) ;
}
