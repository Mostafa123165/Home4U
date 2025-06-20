package com.service.business.repository;

import com.service.base.repository.BaseLkpRepository;
import com.service.business.model.FurnitureType;
import org.springframework.stereotype.Repository;

@Repository
public interface FurnitureTypeReps extends BaseLkpRepository<FurnitureType,Integer> {
}

