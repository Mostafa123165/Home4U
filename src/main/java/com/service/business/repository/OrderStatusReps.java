package com.service.business.repository;

import com.service.base.repository.BaseLkpRepository;
import com.service.common.model.OrderStatus;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderStatusReps extends BaseLkpRepository<OrderStatus,Integer> {
}
