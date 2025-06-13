package com.service.business.controller;

import com.service.base.controller.BaseControllerImpl;
import com.service.base.model.SuccessResponseList;
import com.service.business.dto.OrderDto;
import com.service.business.mapper.OrderMapper;
import com.service.business.model.Order;
import com.service.business.service.OrderService;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Schema(name = "Order")
@RequestMapping("api/v1/orders")
public class OrderController extends BaseControllerImpl<Order, OrderDto, Long> {

    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> findByUserId(@PathVariable Long userId,
                                          @RequestParam Optional<String> statusCode){
        return ResponseEntity.ok(new SuccessResponseList<>(orderMapper.mapToSimple(orderService.findByUserIdAndOrderStatus(userId,statusCode))));
    }
}

