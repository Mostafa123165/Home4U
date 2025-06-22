package com.service.freelancer.repository;

import com.service.base.repository.BaseRepository;
import com.service.freelancer.model.EngineeringOfficeRating;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EngineeringOfficeRatingReps extends BaseRepository<EngineeringOfficeRating, Long> {

    @Query("""
        from EngineeringOfficeRating w
        where w.engineeringOffice.id = :engineeringOfficeId
        """)
    List<EngineeringOfficeRating> findByEngineerOfficeId(Long engineeringOfficeId);
}
