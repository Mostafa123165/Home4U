package com.service.freelancer.repository;

import com.service.base.repository.BaseRepository;
import com.service.freelancer.model.RequestRequestDesign;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRequestDesignReps extends BaseRepository<RequestRequestDesign, Long> {
    @Query("""
            FROM RequestRequestDesign r
            join r.requestDesign a
            WHERE a.id = :askId
            """)
    List<RequestRequestDesign> getByAskId(Long askId);
}