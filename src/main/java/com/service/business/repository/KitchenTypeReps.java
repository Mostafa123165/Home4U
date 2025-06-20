package com.service.business.repository;

import com.service.base.repository.BaseLkpRepository;
import com.service.business.model.KitchenType;
import org.springframework.stereotype.Repository;

@Repository
public interface KitchenTypeReps extends BaseLkpRepository<KitchenType,Integer> {
}

