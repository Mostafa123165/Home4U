package com.service.freelancer.repository;

import com.service.base.repository.BaseLkpRepository;
import com.service.freelancer.model.UnitWorkTypes;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitWorkTypesReps extends BaseLkpRepository<UnitWorkTypes, Integer> {
}
