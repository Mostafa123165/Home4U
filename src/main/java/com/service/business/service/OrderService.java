package com.service.business.service;

import com.service.base.Constant;
import com.service.base.service.BaseServiceImpl;
import com.service.business.model.Order;
import com.service.business.repository.OrderRepository;
import com.service.common.model.OrderStatus;
import com.service.common.service.OrderNumberSeqService;
import com.service.userManagement.service.UserService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Constants;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderService extends BaseServiceImpl<Order, Long> {

    private final UserService userService;
    private final OrderRepository orderRepository;
    private final OrderNumberSeqService orderNumberSeqService;
    private final OrderStatusService orderStatusService;

    @Override
    @Transactional
    public Order insert(Order entity) {
        entity.associateOrderDetails();
        setCurrentUser(entity);
        entity.setOrderNumber(orderNumberSeqService.generateOrderNumber());
        entity.setStatus(orderStatusService.findByCode(Constant.OrderStatusEnum.PENDING));
        return super.insert(entity);
    }

    @Override
    public Order update(Order entity) {
        entity.associateOrderDetails();
        return super.update(entity);
    }

    private void setCurrentUser(Order order) {
        order.setUser(userService.getCurrentUser());
    }

    public List<Order> findByUserIdAndOrderStatus(Long userId, Optional<String> statusCode) {
        return orderRepository.findByUserIdAndOrderStatus(
                userId,
                statusCode.orElse(null));
    }
}
