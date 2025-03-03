package com.service.business.service;

import com.service.base.service.BaseLkpServiceImpl;
import com.service.business.model.BusinessType;
import com.service.business.repository.BusinessTypeReps;
import com.service.common.model.Governorate;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BusinessTypeService extends BaseLkpServiceImpl<BusinessType,Integer> {

    private final BusinessTypeReps businessTypeReps;

    @Cacheable(value = "BusinessType",key = "#root.methodName + '_' + #root.args")
    public List<BusinessType> findByUserType(Integer userTypeId) {
        return businessTypeReps.findByUserTypeId(userTypeId);
    }

    @Override
    @Cacheable(value = "BusinessType",key = "#root.methodName")
    public List<BusinessType> findAll() {
        return super.findAll();
    }

    @Override
    @CacheEvict(value = "BusinessType", allEntries = true)
    public BusinessType insert(BusinessType entity) {
        return super.insert(entity);
    }

    @Override
    @CacheEvict(value = "BusinessType", allEntries = true)
    public BusinessType update(BusinessType entity) {
        return super.update(entity);
    }
}
