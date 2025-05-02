package com.service.business.repository;

import com.service.base.repository.BaseLkpRepository;
import com.service.business.model.BusinessTypeCategory;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusinessTypeCategoryReps extends BaseLkpRepository<BusinessTypeCategory,Integer> {

    @EntityGraph(attributePaths = {"businessType"})
    List<BusinessTypeCategory> findByBusinessTypeId(Integer businessTypeId);


    @EntityGraph(attributePaths = {"businessType"})
    @Override
    List<BusinessTypeCategory> findAll();
}
