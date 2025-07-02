package com.service.freelancer.repository;

import com.service.base.repository.BaseRepository;
import com.service.freelancer.model.RequestHomeRenovate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestHomeRenovateReps extends BaseRepository<RequestHomeRenovate, Long> {
    @Query("""
            FROM RequestHomeRenovate r
            join r.homeRenovate a
            WHERE a.id = :askId
            """)
    List<RequestHomeRenovate> getByAskId(Long askId);
}