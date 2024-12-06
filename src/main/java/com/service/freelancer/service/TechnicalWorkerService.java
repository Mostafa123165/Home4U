package com.service.freelancer.service;

import com.service.base.Constant;
import com.service.base.service.BaseServiceImpl;
import com.service.freelancer.model.Engineer;
import com.service.freelancer.model.TechnicalWorker;
import com.service.freelancer.repository.EngineerReps;
import com.service.freelancer.repository.TechnicalWorkerReps;
import com.service.userManagement.model.User;
import com.service.userManagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TechnicalWorkerService extends BaseServiceImpl<TechnicalWorker, Long> {

    private final TechnicalWorkerReps technicalWorkerReps;

    private final UserService userService;

    @Override
    public TechnicalWorker insert(TechnicalWorker entity) {
        return technicalWorkerReps.save(entity);
    }


}
