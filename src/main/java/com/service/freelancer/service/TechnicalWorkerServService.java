package com.service.freelancer.service;

import com.service.base.service.BaseLkpServiceImpl;
import com.service.freelancer.model.TechnicalWorker;
import com.service.freelancer.model.TechnicalWorkerServ;
import com.service.freelancer.repository.TechnicalWorkerServReps;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TechnicalWorkerServService extends BaseLkpServiceImpl<TechnicalWorkerServ, Integer> {

    private final TechnicalWorkerServReps technicalWorkerServReps;

    private final TechnicalWorkerService technicalWorkerService;

    public void deleteWorkerServiceByWorkerIdAndServiceId(Long workerId, Long serviceId) {
        technicalWorkerServReps.deleteWorkerServiceByWorkerIdAndServiceId(workerId, serviceId);
    }

    public List<TechnicalWorkerServ> getService(Long id) {
        return technicalWorkerServReps.getService(id);
    }


    public List<TechnicalWorkerServ> getOwnEngineerServices(Long workerId) {
        return technicalWorkerServReps.getOwnTechnicalWorkerServices(workerId);
    }

    public void updateOwnEngineerServices(Long userId,List<TechnicalWorkerServ> engineerServs) {
        TechnicalWorker technicalWorker = technicalWorkerService.findByUserId(userId);
        technicalWorker.setWorkerServs(engineerServs);
        technicalWorkerService.update(technicalWorker);
    }
}
