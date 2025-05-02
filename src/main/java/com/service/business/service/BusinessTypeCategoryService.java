package com.service.business.service;

import com.service.base.service.BaseLkpServiceImpl;
import com.service.business.model.BusinessType;
import com.service.business.model.BusinessTypeCategory;
import com.service.business.repository.BusinessTypeCategoryReps;
import com.service.business.repository.BusinessTypeReps;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BusinessTypeCategoryService extends BaseLkpServiceImpl<BusinessTypeCategory,Integer> {

    private final BusinessTypeCategoryReps businessTypeCategoryReps;

    @Cacheable(value = "BusinessType",key = "#root.methodName + '_' + #root.args")
    public List<BusinessTypeCategory> findByBusinessTypeId(Integer userTypeId) {
        return businessTypeCategoryReps.findByBusinessTypeId(userTypeId);
    }

    @Override
    @Cacheable(value = "BusinessTypeCategory",key = "#root.methodName")
    public List<BusinessTypeCategory> findAll() {
        return super.findAll();
    }

    @Override
    @CacheEvict(value = "BusinessTypeCategory", allEntries = true)
    public BusinessTypeCategory insert(BusinessTypeCategory entity) {
        return super.insert(entity);
    }

    @Override
    @CacheEvict(value = "BusinessTypeCategory", allEntries = true)
    public BusinessTypeCategory update(BusinessTypeCategory entity) {
        return super.update(entity);
    }
}
