package com.service.freelancer.repository;

import com.service.base.repository.BaseRepository;
import com.service.freelancer.model.AskWorker;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AskWorkerReps extends BaseRepository<AskWorker, Long> {

    @Query("""
    FROM AskWorker askWorker
    JOIN askWorker.unitType unitType
    JOIN askWorker.governorate governorate
    JOIN askWorker.city city
    JOIN askWorker.user user
    JOIN askWorker.workerType workerType
    JOIN askWorker.material material
    WHERE
        (:userId IS NULL OR user.id = :userId) AND
        (:unitTypeId IS NULL OR unitType.id = :unitTypeId) AND
        (:governorateId IS NULL OR governorate.id = :governorateId) AND
        (:cityId IS NULL OR city.id = :cityId) AND
        (:projectName IS NULL OR askWorker.projectName LIKE CONCAT('%',:projectName,'%')) AND
        (:workerTypeId IS NULL OR workerType.id = :workerTypeId) AND
        (:materialId IS NULL OR material.id = :materialId) AND
        (:budgetFrom IS NULL OR askWorker.budget >= :budgetFrom) AND
        (:budgetTo IS NULL OR askWorker.budget <= :budgetTo)
    """)
    Page<AskWorker> filter(Long userId, Integer unitTypeId, Integer governorateId, Integer cityId, String projectName, Integer workerTypeId, Integer materialId, Long budgetFrom, Long budgetTo, Pageable pageable);
}
