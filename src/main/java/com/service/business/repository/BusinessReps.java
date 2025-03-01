package com.service.business.repository;

import com.service.base.repository.BaseRepository;
import com.service.business.model.Business;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessReps extends BaseRepository<Business,Long> {
    Business findByUserId(Long id);
}
