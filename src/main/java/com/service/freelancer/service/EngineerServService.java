package com.service.freelancer.service;

import com.service.base.service.BaseLkpServiceImpl;
import com.service.freelancer.model.EngineerServ;
import com.service.freelancer.repository.EngineerServReps;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EngineerServService extends BaseLkpServiceImpl<EngineerServ, Integer> {

    private final EngineerServReps engineerServReps;

    public List<EngineerServ> getService(Long id) {
        return engineerServReps.getService(id);
    }
}
