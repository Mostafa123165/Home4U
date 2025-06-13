package com.service.business.service;

import com.service.base.service.BaseLkpServiceImpl;
import com.service.common.model.OrderStatus;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderStatusService extends BaseLkpServiceImpl<OrderStatus,Integer> {


    @Override
    @Cacheable(value = "OrderStatus",key = "#root.methodName + #code")
    public OrderStatus findByCode(String code) {
        return super.findByCode(code);
    }

    @Override
    @CacheEvict(value = "OrderStatus", allEntries = true)
    public OrderStatus insert(OrderStatus entity) {
        return super.insert(entity);
    }

    @Override
    @CacheEvict(value = "OrderStatus", allEntries = true)
    public OrderStatus update(OrderStatus entity) {
        return super.update(entity);
    }

    @Override
    @Cacheable(value = "OrderStatus",key = "#root.methodName")
    public List<OrderStatus> findAll() {
        return super.findAll();
    }
}
