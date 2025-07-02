package com.service.freelancer.repository;

import com.service.base.repository.BaseRepository;
import com.service.freelancer.model.RequestAskEngineer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestAskEngineerReps extends BaseRepository<RequestAskEngineer, Long> {
    @Query("""
        FROM RequestAskEngineer r
        join r.askEngineer a
        WHERE a.id = :askId
        """)
    List<RequestAskEngineer> getByAskId(Long askId);
}
