package com.service.business.service;

import com.service.base.Constant;
import com.service.base.service.BaseServiceImpl;
import com.service.business.model.Order;
import com.service.business.model.OrderDetails;
import com.service.business.repository.OrderRepository;
import com.service.common.service.MessageSourceService;
import com.service.common.service.OrderNumberSeqService;
import com.service.error.BadRequestException;
import com.service.userManagement.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderService extends BaseServiceImpl<Order, Long> {

    private final UserService userService;
    private final OrderRepository orderRepository;
    private final OrderNumberSeqService orderNumberSeqService;
    private final OrderStatusService orderStatusService;
    private final MessageSourceService messageSourceService;

    @Override
    @Transactional
    public Order insert(Order entity) {
        validateTotalPrice(entity);
        entity.associateOrderDetails();
        setCurrentUser(entity);
        entity.setOrderNumber(orderNumberSeqService.generateOrderNumber());
        entity.setStatus(orderStatusService.findByCode(Constant.OrderStatusEnum.PENDING));
        return super.insert(entity);
    }

    private void validateTotalPrice(Order order) {
        double totalPrice = order.getOrderDetails().stream().mapToDouble(OrderDetails::getPrice).sum();
        totalPrice = new BigDecimal(totalPrice).setScale(2, RoundingMode.HALF_UP).doubleValue();
        if(order.getTotalPrice() - totalPrice > 0.02 || order.getTotalPrice() - totalPrice < -0.02) {
            throw new BadRequestException("The total price does not match the sum of order details prices.");
        }
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

    @Transactional
    public void updateOldOrdersToDelivered() {
        orderRepository.updateOldOrdersToDelivered();
    }


    @Transactional
    public void cancelOrder(Long orderId) {
        Order order = findById(orderId);
        validateOrderStatus(order);
        orderRepository.cancelOrder(orderId,Constant.OrderStatusEnum.CANCELED);
    }

    private void validateOrderStatus(Order order) {
        if(order.getStatus().getCode().equals(Constant.OrderStatusEnum.CANCELED) ||
                order.getStatus().getCode().equals(Constant.OrderStatusEnum.DELIVERED)) {
            throw new BadRequestException(messageSourceService.getMessage("validation.order.cannot.cancel",
                    new String[]{order.getStatus().getNameEn()}));
        }
    }
}
