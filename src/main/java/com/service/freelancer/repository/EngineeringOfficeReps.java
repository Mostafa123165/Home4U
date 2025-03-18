package com.service.freelancer.repository;

import com.service.base.repository.BaseRepository;
import com.service.freelancer.model.EngineeringOffice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EngineeringOfficeReps extends BaseRepository<EngineeringOffice, Long> {
    @Query("""
                from EngineeringOffice w
                where w.user.id = :userId
                """)
    EngineeringOffice findByUserId(Long userId);}
