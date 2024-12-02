package com.service.common.repository;

import com.service.base.repository.BaseLkpRepository;
import com.service.common.model.City;
import com.service.common.model.Governorate;
import org.springframework.stereotype.Repository;

@Repository
public interface CityReps extends BaseLkpRepository<City,Integer> {
}
