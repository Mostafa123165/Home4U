package com.service.business.repository;

import com.service.base.repository.BaseLkpRepository;
import com.service.base.repository.BaseRepository;
import com.service.business.model.BusinessType;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusinessTypeReps extends BaseLkpRepository<BusinessType,Integer> {

    List<BusinessType> findByUserTypeId(Integer userTypeId);
}
