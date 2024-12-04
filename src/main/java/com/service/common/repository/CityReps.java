package com.service.common.repository;

import com.service.base.repository.BaseLkpRepository;
import com.service.common.model.City;
import com.service.common.model.Governorate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityReps extends BaseLkpRepository<City,Integer> {

    List<City> findByGovernorateId(Integer governorateId);
}
