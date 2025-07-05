package com.service.freelancer.repository;

import com.service.base.repository.BaseRepository;
import com.service.freelancer.model.TechnicalWorker;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TechnicalWorkerReps extends BaseRepository<TechnicalWorker, Long> {
    @Query("""
                from TechnicalWorker w
                where w.user.id = :userId
                """)
    TechnicalWorker findByUserId(Long userId);

    @Query("""
                FROM TechnicalWorker technicalWorker
                JOIN technicalWorker.user user
                JOIN user.governorate governorate
                JOIN user.city city
                JOIN technicalWorker.workerServs technicalWorkerServ
                JOIN technicalWorker.type technicalWorkerType
                WHERE
                    (:governorateId IS NULL OR governorate.id = :governorateId) AND
                    (:cityId IS NULL OR city.id = :cityId) AND
                    (:technicalWorkerTypeId IS NULL OR technicalWorkerType.id = :technicalWorkerTypeId) AND
                    (:technicalWorkerServId IS NULL OR technicalWorkerServ.id = :technicalWorkerServId) AND
                    (:yearsOfExperience IS NULL OR technicalWorker.yearsOfExperience >= :yearsOfExperience) AND
                    (:rate IS NULL OR technicalWorker.averageRate >= :rate)
                ORDER BY technicalWorker.averageRate DESC
            """)
    Page<TechnicalWorker> filterTop(Number governorateId, Number cityId, Number technicalWorkerTypeId, Integer yearsOfExperience, Number technicalWorkerServId, Integer rate, Pageable pageable);

    @Query("""
        FROM TechnicalWorker technicalWorker
            ORDER BY technicalWorker.averageRate DESC
                limit 10
       """)
    List<TechnicalWorker> LandingPage();
}
