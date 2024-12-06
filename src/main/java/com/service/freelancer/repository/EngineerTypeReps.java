package com.service.freelancer.repository;

import com.service.base.repository.BaseLkpRepository;
import com.service.freelancer.model.EngineerType;
import org.springframework.stereotype.Repository;

@Repository
public interface EngineerTypeReps extends BaseLkpRepository<EngineerType, Integer> {
}
