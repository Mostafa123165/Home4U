package com.service.freelancer.service;

import com.service.base.service.BaseServiceImpl;
import com.service.freelancer.model.EngineeringOfficeRating;
import com.service.freelancer.repository.EngineeringOfficeRatingReps;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EngineeringOfficeRatingService extends BaseServiceImpl<EngineeringOfficeRating, Long> {

    private final EngineeringOfficeRatingReps engineeringOfficeRatingReps;

    public List<EngineeringOfficeRating> findByEngineerOfficeId(Long engineeringOfficeId) {
        return engineeringOfficeRatingReps.findByEngineerOfficeId(engineeringOfficeId);
    }
}
