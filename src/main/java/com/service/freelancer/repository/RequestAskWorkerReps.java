package com.service.freelancer.repository;

import com.service.base.repository.BaseRepository;
import com.service.freelancer.model.RequestAskWorker;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestAskWorkerReps extends BaseRepository<RequestAskWorker, Long> {

    @Query("""
        FROM RequestAskWorker r
        join r.askWorker a
        WHERE a.id = :askId
        """)
    List<RequestAskWorker> getByAskId(Long askId);
}
