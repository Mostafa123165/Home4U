package com.service.common.service;

import com.service.base.service.BaseLkpServiceImpl;
import com.service.common.model.City;
import com.service.common.model.Governorate;
import com.service.common.repository.CityReps;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CityService extends BaseLkpServiceImpl<City,Integer> {

    private final CityReps cityReps;

    @Cacheable(value = "cities", key = "#root.methodName + '_'+ #root.args")
    public List<City> findByGovernorateId(Integer governorateId) {
        return cityReps.findByGovernorateId(governorateId);
    }

    @Override
    @CacheEvict(value = "cities", allEntries = true)
    public City insert(City entity) {
        return super.insert(entity);
    }

    @Override
    @CacheEvict(value = "cities", allEntries = true)
    public City update(City entity) {
        return super.update(entity);
    }
}
