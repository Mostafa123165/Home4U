package com.service.freelancer.repository;

import com.service.base.repository.BaseRepository;
import com.service.freelancer.model.Engineer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EngineerReps extends BaseRepository<Engineer, Long> {
    @Query("""
                from Engineer e
                where e.user.id = :userId
                """)
    Engineer findByUserId(Long userId);
}
