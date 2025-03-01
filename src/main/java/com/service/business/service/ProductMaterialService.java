package com.service.business.service;

import com.service.base.service.BaseLkpServiceImpl;
import com.service.business.model.ProductMaterial;
import com.service.common.model.Color;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductMaterialService extends BaseLkpServiceImpl<ProductMaterial,Integer> {


    @Override
    @CacheEvict(value = "ProductMaterial", allEntries = true)
    public ProductMaterial insert(ProductMaterial entity) {
        return super.insert(entity);
    }

    @Override
    @CacheEvict(value = "ProductMaterial", allEntries = true)
    public ProductMaterial update(ProductMaterial entity) {
        return super.update(entity);
    }

    @Override
    @Cacheable(value = "ProductMaterial",key = "#root.methodName")
    public List<ProductMaterial> findAll() {
        return super.findAll();
    }
}
