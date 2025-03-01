package com.service.business.service;

import com.service.base.service.BaseLkpServiceImpl;
import com.service.business.model.ProductBaseUnit;
import com.service.common.model.Color;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ColorService extends BaseLkpServiceImpl<Color,Integer> {


    @Override
    @CacheEvict(value = "Color", allEntries = true)
    public Color insert(Color entity) {
        return super.insert(entity);
    }

    @Override
    @CacheEvict(value = "Color", allEntries = true)
    public Color update(Color entity) {
        return super.update(entity);
    }

    @Override
    @Cacheable(value = "Color",key = "#root.methodName")
    public List<Color> findAll() {
        return super.findAll();
    }
}
