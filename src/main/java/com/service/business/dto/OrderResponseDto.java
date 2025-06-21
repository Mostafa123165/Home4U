package com.service.business.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderResponseDto {

    private Long userId;
    private String orderNumber;
    private String deliveryAddress;
    private List<OrderDetailsResponseDto> orderDetails;
    private double totalPrice;

}
