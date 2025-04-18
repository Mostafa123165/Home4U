package com.service.freelancer.repository;

import com.service.base.repository.BaseLkpRepository;
import com.service.freelancer.model.UrgencyLevel;
import org.springframework.stereotype.Repository;

@Repository
public interface UrgencyLevelReps extends BaseLkpRepository<UrgencyLevel, Integer> {
}
