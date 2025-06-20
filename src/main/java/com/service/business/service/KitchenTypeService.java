package com.service.business.service;

import com.service.base.service.BaseLkpServiceImpl;
import com.service.business.model.KitchenType;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class KitchenTypeService extends BaseLkpServiceImpl<KitchenType, Integer> {

    @Override
    @Cacheable(value = "KitchenType", key = "#root.methodName + #code")
    public KitchenType findByCode(String code) {
        return super.findByCode(code);
    }

    @Override
    @CacheEvict(value = "KitchenType", allEntries = true)
    public KitchenType insert(KitchenType entity) {
        return super.insert(entity);
    }

    @Override
    @CacheEvict(value = "KitchenType", allEntries = true)
    public KitchenType update(KitchenType entity) {
        return super.update(entity);
    }

    @Override
    @Cacheable(value = "KitchenType", key = "#root.methodName")
    public List<KitchenType> findAll() {
        return super.findAll();
    }
}
