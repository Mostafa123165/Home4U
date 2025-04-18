package com.service.freelancer.repository;

import com.service.base.repository.BaseLkpRepository;
import com.service.freelancer.model.UnitStatuses;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitStatusesReps extends BaseLkpRepository<UnitStatuses, Integer> {
}
