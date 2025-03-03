package com.service.business.repository;

import com.service.base.repository.BaseLkpRepository;
import com.service.common.model.Color;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorReps extends BaseLkpRepository<Color,Integer> {
}
