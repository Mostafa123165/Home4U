package com.service.business.service;

import com.service.base.service.BaseLkpServiceImpl;
import com.service.business.model.HomeFurnishingRequestType;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HomeFurnishingRequestTypeService extends BaseLkpServiceImpl<HomeFurnishingRequestType, Integer> {

    @Override
    @Cacheable(value = "HomeFurnishingRequestType", key = "#root.methodName + #code")
    public HomeFurnishingRequestType findByCode(String code) {
        return super.findByCode(code);
    }

    @Override
    @CacheEvict(value = "HomeFurnishingRequestType", allEntries = true)
    public HomeFurnishingRequestType insert(HomeFurnishingRequestType entity) {
        return super.insert(entity);
    }

    @Override
    @CacheEvict(value = "HomeFurnishingRequestType", allEntries = true)
    public HomeFurnishingRequestType update(HomeFurnishingRequestType entity) {
        return super.update(entity);
    }

    @Override
    @Cacheable(value = "HomeFurnishingRequestType", key = "#root.methodName")
    public List<HomeFurnishingRequestType> findAll() {
        return super.findAll();
    }
}
