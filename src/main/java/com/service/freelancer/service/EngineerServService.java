package com.service.freelancer.service;

import com.service.base.service.BaseLkpServiceImpl;
import com.service.freelancer.model.Engineer;
import com.service.freelancer.model.EngineerServ;
import com.service.freelancer.repository.EngineerServReps;
import com.service.userManagement.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EngineerServService extends BaseLkpServiceImpl<EngineerServ, Integer> {

    private final EngineerServReps engineerServReps;
    private final EngineerService engineerService;

    public List<EngineerServ> getService(Long id) {
        return engineerServReps.getService(id);
    }

    public List<EngineerServ> getEngineerServices(Long engineerId) {
        return engineerServReps.getEngineerServices(engineerId);
    }

    public void updateOwnEngineerServices(Long userId,List<EngineerServ> engineerServs) {
        Engineer engineer = engineerService.findByUserId(userId);
        engineer.setEngineerServ(engineerServs);
        engineerService.update(engineer);
    }

    public void deleteEngineerServiceByEngineerIdAndServiceId(Long engineerId, Long serviceId) {
        engineerServReps.deleteEngineerServiceByEngineerIdAndServiceId(engineerId, serviceId);
    }
}
