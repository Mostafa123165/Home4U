package com.service.freelancer.repository;

import com.service.base.mapper.BaseMapper;
import com.service.base.repository.BaseRepository;
import com.service.freelancer.model.HomeRenovate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeRenovateReps extends BaseRepository<HomeRenovate, Long> {

    @Query("""
    from HomeRenovate renovate
    JOIN renovate.unitType unitType
    JOIN renovate.governorate governorate
    JOIN renovate.city city
    JOIN renovate.user user
    JOIN renovate.unitWorkTypes unitWorkType
    JOIN renovate.workSkills workSkill
    JOIN renovate.unitStatuses unitStatus
    where
        (:userId IS NULL OR user.id = :userId) AND
        (:unitTypeId IS NULL OR unitType.id = :unitTypeId) AND
        (:governorateId IS NULL OR governorate.id = :governorateId) AND
        (:cityId IS NULL OR city.id = :cityId) AND
        (:unitStatusId IS NULL OR unitStatus.id = :unitStatusId) AND
        (:workSkillId IS NULL OR workSkill.id = :workSkillId) AND
        (:unitWorkTypeId IS NULL OR unitWorkType.id = :unitWorkTypeId) AND
        (:unitAreaFrom IS NULL OR renovate.unitArea >= :unitAreaFrom) AND
        (:unitAreaTo IS NULL OR renovate.unitArea <= :unitAreaTo) AND
        (:budgetFrom IS NULL OR renovate.budget >= :budgetFrom) AND
        (:budgetTo IS NULL OR renovate.budget <= :budgetTo) AND
        (:requiredDurationFrom IS NULL OR renovate.requiredDuration >= :requiredDurationFrom) AND
        (:requiredDurationTo IS NULL OR renovate.requiredDuration <= :requiredDurationTo)
""")
    Page<HomeRenovate> filter(
            Long userId,
            Integer unitTypeId, Integer governorateId, Integer cityId, Integer unitStatusId, Integer workSkillId, Integer unitWorkTypeId,
            Long budgetFrom, Long budgetTo, Long unitAreaFrom, Long unitAreaTo, Long requiredDurationFrom, Long requiredDurationTo, Pageable pageable);
}
