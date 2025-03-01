package com.service.business.service;

import com.service.base.service.BaseLkpServiceImpl;
import com.service.business.model.ProductBaseUnit;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductBaseUnitService extends BaseLkpServiceImpl<ProductBaseUnit,Integer> {


    @Override
    @CacheEvict(value = "ProductBaseUnit", allEntries = true)
    public ProductBaseUnit insert(ProductBaseUnit entity) {
        return super.insert(entity);
    }

    @Override
    @CacheEvict(value = "ProductBaseUnit", allEntries = true)
    public ProductBaseUnit update(ProductBaseUnit entity) {
        return super.update(entity);
    }

    @Override
    @Cacheable(value = "ProductBaseUnit",key = "#root.methodName")
    public List<ProductBaseUnit> findAll() {
        return super.findAll();
    }
}
