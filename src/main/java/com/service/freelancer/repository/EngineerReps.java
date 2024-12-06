package com.service.freelancer.repository;

import com.service.base.repository.BaseRepository;
import com.service.freelancer.model.Engineer;
import org.springframework.stereotype.Repository;

@Repository
public interface EngineerReps extends BaseRepository<Engineer, Long> {
}
