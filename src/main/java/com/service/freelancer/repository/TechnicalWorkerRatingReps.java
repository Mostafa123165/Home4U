package com.service.freelancer.repository;

import com.service.base.repository.BaseRepository;
import com.service.freelancer.model.TechnicalWorkerRating;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TechnicalWorkerRatingReps extends BaseRepository<TechnicalWorkerRating, Long> {

    @Query("""
        from TechnicalWorkerRating w
        where w.technicalWorker.id = :workerId
        """)
    List<TechnicalWorkerRating> findByTechnicalWorkerRatingId(Long workerId);
}
