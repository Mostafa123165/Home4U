package com.service.common.service;

import com.service.base.service.BaseLkpServiceImpl;
import com.service.common.model.Governorate;
import com.service.userManagement.model.UserType;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GovernorateService extends BaseLkpServiceImpl<Governorate,Integer> {

    @Override
    @Cacheable(value = "governorates", key = "#root.methodName")
    public List<Governorate> findAll() {
        return super.findAll();
    }

    @Override
    @CacheEvict(value = "governorates", allEntries = true)
    public Governorate insert(Governorate entity) {
        return super.insert(entity);
    }

    @Override
    @CacheEvict(value = "governorates", allEntries = true)
    public Governorate update(Governorate entity) {
        return super.update(entity);
    }
}
