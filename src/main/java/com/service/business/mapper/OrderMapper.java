package com.service.business.mapper;

import com.service.base.mapper.BaseMapper;
import com.service.business.dto.OrderDto;
import com.service.business.dto.OrderResponseDto;
import com.service.business.dto.OrderSimpleDto;
import com.service.business.model.Order;
import org.aspectj.weaver.ast.Or;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.List;

@Mapper(imports = {LocaleContextHolder.class},uses = {OrderStatusMapper.class,OrderStatusMapper.class,OrderDetailsMapper.class})
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


    @Mappings({
            @Mapping(target = "userId", source = "user.id"),
            @Mapping(target = "deliveryAddress",expression = "java(getDeliveryAddress(t))"),
    })
    OrderResponseDto mapToResponse(Order t);

    List<OrderResponseDto> mapToResponse(List<Order> byId);


    default String getDeliveryAddress(Order order) {
        if (order.getUser() == null || order.getUser().getGovernorate() == null || order.getUser().getCity() == null) {
            return "Address not available";
        }
        if(LocaleContextHolder.getLocale().getLanguage().equals("ar")) {
            return order.getUser().getGovernorate().getNameAr() + ", " + order.getUser().getCity().getNameAr();
        }
        return order.getUser().getGovernorate().getNameEn() + ", " + order.getUser().getCity().getNameEn();
    }
}
