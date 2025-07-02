package com.service.freelancer.repository;

import com.service.base.repository.BaseRepository;
import com.service.freelancer.model.Engineer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EngineerReps extends BaseRepository<Engineer, Long> {
    @Query("""
                from Engineer e
                where e.user.id = :userId
                """)
    Engineer findByUserId(Long userId);

    @Query("""
                FROM Engineer engineer
                JOIN engineer.user user
                JOIN user.governorate governorate
                JOIN user.city city
                JOIN engineer.engineerServ engineerServ
                JOIN engineer.type engineerType
                WHERE
                    (:governorateId IS NULL OR governorate.id = :governorateId) AND
                    (:cityId IS NULL OR city.id = :cityId) AND
                    (:engineerTypeId IS NULL OR engineerType.id = :engineerTypeId) AND
                    (:engineerServId IS NULL OR engineerServ.id = :engineerServId) AND
                    (:yearsOfExperience IS NULL OR engineer.yearsOfExperience >= :yearsOfExperience) AND
                    (:rate IS NULL OR engineer.averageRate >= :rate)
                ORDER BY engineer.averageRate DESC
            """)
    Page<Engineer> filterTop(Number governorateId, Number cityId, Number engineerTypeId, Integer yearsOfExperience, Number engineerServId, Integer rate, Pageable pageable);
}
