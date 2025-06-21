package com.service.freelancer.service;

import com.service.base.service.BaseServiceImpl;
import com.service.freelancer.model.TechnicalWorkerRating;
import com.service.freelancer.repository.TechnicalWorkerRatingReps;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TechnicalWorkerRatingService extends BaseServiceImpl<TechnicalWorkerRating, Long> {

    private final TechnicalWorkerRatingReps technicalWorkerRatingReps;

    public List<TechnicalWorkerRating> findByTechnicalWorkerRatingId(Long workerId) {
        return technicalWorkerRatingReps.findByTechnicalWorkerRatingId(workerId);
    }
}
