package com.service.business.repository;

import com.service.base.repository.BaseLkpRepository;
import com.service.business.model.ProductMaterial;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductMaterialReps extends BaseLkpRepository<ProductMaterial,Integer> {
}
