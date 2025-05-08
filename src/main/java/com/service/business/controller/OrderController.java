package com.service.business.controller;

import com.service.business.dto.OrderDto;
import com.service.business.model.Order;
import com.service.base.controller.BaseControllerImpl;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Schema(name = "Order")
@RequestMapping("api/v1/orders")
public class OrderController extends BaseControllerImpl<Order, OrderDto, Long> {
}

