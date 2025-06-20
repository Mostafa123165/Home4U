package com.service.business.service;

import com.service.base.service.BaseLkpServiceImpl;
import com.service.business.model.FurnitureType;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FurnitureTypeService extends BaseLkpServiceImpl<FurnitureType,Integer> {

    @Override
    @Cacheable(value = "FurnitureType",key = "#root.methodName + #code")
    public FurnitureType findByCode(String code) {
        return super.findByCode(code);
    }

    @Override
    @CacheEvict(value = "FurnitureType", allEntries = true)
    public FurnitureType insert(FurnitureType entity) {
        return super.insert(entity);
    }

    @Override
    @CacheEvict(value = "FurnitureType", allEntries = true)
    public FurnitureType update(FurnitureType entity) {
        return super.update(entity);
    }

    @Override
    @Cacheable(value = "FurnitureType",key = "#root.methodName")
    public List<FurnitureType> findAll() {
        return super.findAll();
    }
}

