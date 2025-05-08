package com.service.business.service;

import com.service.base.service.BaseServiceImpl;
import com.service.business.model.Order;
import com.service.business.repository.OrderRepository;
import com.service.userManagement.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderService extends BaseServiceImpl<Order, Long> {

    private final UserService userService;
    private final OrderRepository orderRepository;

    @Override
    public Order insert(Order entity) {
        entity.associateOrderDetails();
        setCurrentUser(entity);
        entity.setOrderNumber("ORD-" + System.currentTimeMillis());
        return super.insert(entity);
    }

    private void setCurrentUser(Order order) {
        order.setUser(userService.getCurrentUser());
    }
}
