package com.service.freelancer.repository;

import com.service.base.repository.BaseRepository;
import com.service.freelancer.model.TechnicalWorker;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicalWorkerReps extends BaseRepository<TechnicalWorker, Long> {
    @Query("""
                from TechnicalWorker w
                where w.user.id = :userId
                """)
    TechnicalWorker findByUserId(Long userId);
}
