package com.service.business.repository;

import com.service.business.model.Order;
import com.service.base.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends BaseRepository<Order, Long> {

}

