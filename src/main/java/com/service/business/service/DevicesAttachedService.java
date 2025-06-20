package com.service.business.service;

import com.service.base.service.BaseLkpServiceImpl;
import com.service.business.model.DevicesAttached;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DevicesAttachedService extends BaseLkpServiceImpl<DevicesAttached,Integer> {

    @Override
    @Cacheable(value = "DevicesAttached",key = "#root.methodName + #code")
    public DevicesAttached findByCode(String code) {
        return super.findByCode(code);
    }

    @Override
    @CacheEvict(value = "DevicesAttached", allEntries = true)
    public DevicesAttached insert(DevicesAttached entity) {
        return super.insert(entity);
    }

    @Override
    @CacheEvict(value = "DevicesAttached", allEntries = true)
    public DevicesAttached update(DevicesAttached entity) {
        return super.update(entity);
    }

    @Override
    @Cacheable(value = "DevicesAttached",key = "#root.methodName")
    public List<DevicesAttached> findAll() {
        return super.findAll();
    }
}

