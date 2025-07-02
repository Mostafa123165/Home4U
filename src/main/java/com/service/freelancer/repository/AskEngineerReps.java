package com.service.freelancer.repository;

import com.service.base.repository.BaseRepository;
import com.service.freelancer.model.AskEngineer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AskEngineerReps extends BaseRepository<AskEngineer, Long> {

    @Query("""
        FROM AskEngineer askEngineer
        JOIN askEngineer.unitType unitType
        JOIN askEngineer.governorate governorate
        JOIN askEngineer.city city
        JOIN askEngineer.user user
        JOIN askEngineer.engineerType engineerType
        JOIN askEngineer.urgencyLevel urgencyLevel
        WHERE
            (:userId IS NULL OR user.id = :userId) AND
            (:unitTypeId IS NULL OR unitType.id = :unitTypeId) AND
            (:governorateId IS NULL OR governorate.id = :governorateId) AND
            (:cityId IS NULL OR city.id = :cityId) AND
            (:projectName IS NULL OR askEngineer.projectName LIKE CONCAT('%',:projectName,'%')) AND
            (:engineerTypeId IS NULL OR engineerType.id = :engineerTypeId) AND
            (:urgencyLevelId IS NULL OR urgencyLevel.id = :urgencyLevelId) AND
            (:budgetFrom IS NULL OR askEngineer.budget >= :budgetFrom) AND
            (:budgetTo IS NULL OR askEngineer.budget <= :budgetTo)
""")
    Page<AskEngineer> filter(Long userId, Integer unitTypeId, Integer governorateId, Integer cityId, String projectName, Integer engineerTypeId, Integer urgencyLevelId, Long budgetFrom, Long budgetTo, Pageable pageable);

    @Query("""
        FROM AskEngineer askEngineer
        JOIN askEngineer.user user
        WHERE user.id = :userId
        """)
    List<AskEngineer> getMyAsks(Long userId);
}

