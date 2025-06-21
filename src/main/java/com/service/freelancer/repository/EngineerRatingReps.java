package com.service.freelancer.repository;

import com.service.base.repository.BaseRepository;
import com.service.freelancer.model.EngineerRating;
import org.springframework.stereotype.Repository;

@Repository
public interface EngineerRatingReps extends BaseRepository<EngineerRating, Long> {
}
