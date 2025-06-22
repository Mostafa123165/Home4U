package com.service.freelancer.service;

import com.service.base.service.BaseServiceImpl;
import com.service.freelancer.mapper.EngineerRatingMapper;
import com.service.freelancer.model.EngineerRating;
import com.service.freelancer.repository.EngineerRatingReps;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EngineerRatingService extends BaseServiceImpl<EngineerRating, Long> {

    private final EngineerRatingReps engineerRatingReps;

    public List<EngineerRating> findByEngineerId(Long engineerId) {
        return engineerRatingReps.findByEngineerId(engineerId);
    }
}
