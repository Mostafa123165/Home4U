package com.service.freelancer.service;

import com.service.base.service.BaseLkpServiceImpl;
import com.service.freelancer.model.EngineerServ;
import com.service.freelancer.model.TechnicalWorkerServ;
import com.service.freelancer.repository.EngineerServReps;
import com.service.freelancer.repository.TechnicalWorkerServReps;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TechnicalWorkerServService extends BaseLkpServiceImpl<TechnicalWorkerServ, Integer> {

    private final TechnicalWorkerServReps technicalWorkerServReps;

    public List<TechnicalWorkerServ> getService(Long id) {
        return technicalWorkerServReps.getService(id);
    }
}
