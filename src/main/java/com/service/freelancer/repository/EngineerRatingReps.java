package com.service.freelancer.repository;

import com.service.base.repository.BaseRepository;
import com.service.freelancer.model.EngineerRating;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EngineerRatingReps extends BaseRepository<EngineerRating, Long> {

    @Query("""
        from EngineerRating w
        where w.engineer.id = :engineerId
        """)
    List<EngineerRating> findByEngineerId(Long engineerId);
}
