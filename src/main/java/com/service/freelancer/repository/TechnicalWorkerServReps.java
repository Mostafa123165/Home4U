package com.service.freelancer.repository;

import com.service.base.repository.BaseLkpRepository;
import com.service.freelancer.model.EngineerServ;
import com.service.freelancer.model.TechnicalWorkerServ;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TechnicalWorkerServReps extends BaseLkpRepository<TechnicalWorkerServ, Integer> {

    @Query("select e from TechnicalWorkerServ e " +
            "where (e.technicalWorkerType.id = :id or e.technicalWorkerType is null) AND e.statusCode =5 ")
    List<TechnicalWorkerServ> getService(Long id);
}
