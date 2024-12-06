package com.service.freelancer.repository;

import com.service.base.repository.BaseLkpRepository;
import com.service.freelancer.model.TechnicalWorkerType;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicalWorkerTypeReps extends BaseLkpRepository<TechnicalWorkerType, Integer> {
}
