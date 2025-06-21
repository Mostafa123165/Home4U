package com.service.business.controller;

import com.service.base.controller.BaseControllerImpl;
import com.service.base.model.SuccessResponse;
import com.service.base.model.SuccessResponseList;
import com.service.business.dto.OrderDto;
import com.service.business.dto.OrderResponseDto;
import com.service.business.mapper.OrderMapper;
import com.service.business.model.Order;
import com.service.business.service.OrderService;
import com.service.common.service.MessageSourceService;
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
    private final MessageSourceService messageSourceService;

    @Override
    public ResponseEntity<?> findById(Long id) {
        OrderResponseDto dto = orderMapper.mapToResponse(orderService.findById(id));
        return ResponseEntity.ok(new SuccessResponse<>(dto));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> findByUserId(@PathVariable Long userId,
                                          @RequestParam Optional<String> statusCode){
        return ResponseEntity.ok(new SuccessResponseList<>(orderMapper.mapToSimple(orderService.findByUserIdAndOrderStatus(userId,statusCode))));
    }

    @PutMapping("/cancel/{orderId}")
    private ResponseEntity<?> cancelOrder(@PathVariable Long orderId) {
        orderService.cancelOrder(orderId);
        return ResponseEntity.ok(new SuccessResponse<>(messageSourceService.getMessage("success.order.cancelled")));
    }
}
