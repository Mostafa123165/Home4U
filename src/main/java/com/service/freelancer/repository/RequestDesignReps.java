package com.service.freelancer.repository;

import com.service.base.repository.BaseRepository;
import com.service.freelancer.model.RequestDesign;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface RequestDesignReps extends BaseRepository<RequestDesign, Long> {

    @Query("""
    SELECT request
    FROM RequestDesign request
        JOIN request.unitType unitType
        JOIN request.governorate governorate
        JOIN request.user user
    WHERE
        (:userId IS NULL OR user.id = :userId) AND
        (:unitTypeId IS NULL OR unitType.id = :unitTypeId) AND
        (:governorateId IS NULL OR governorate.id = :governorateId) AND
        (:unitAreaFrom IS NULL OR request.unitArea >= :unitAreaFrom) AND
        (:unitAreaTo IS NULL OR request.unitArea <= :unitAreaTo) AND
        (:budgetFrom IS NULL OR request.budget >= :budgetFrom) AND
        (:budgetTo IS NULL OR request.budget <= :budgetTo) AND
        (:requiredDurationFrom IS NULL OR request.requiredDuration >= :requiredDurationFrom) AND
        (:requiredDurationTo IS NULL OR request.requiredDuration <= :requiredDurationTo) 
""")
    Page<RequestDesign> filter(
            Long userId, Integer unitTypeId, Integer governorateId,
            Long budgetFrom, Long budgetTo,
            Long unitAreaFrom, Long unitAreaTo,
            Long requiredDurationFrom, Long requiredDurationTo,
            Pageable pageable
    );

}
