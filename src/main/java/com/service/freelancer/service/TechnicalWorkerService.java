package com.service.freelancer.service;

import com.service.base.service.BaseServiceImpl;
import com.service.freelancer.model.TechnicalWorker;
import com.service.freelancer.repository.TechnicalWorkerReps;
import com.service.userManagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TechnicalWorkerService extends BaseServiceImpl<TechnicalWorker, Long> {

    private final UserService userService;
    private final TechnicalWorkerReps technicalWorkerReps;

    public TechnicalWorker findByUserId(Long userId) {
        if (userId == null) userId = userService.getCurrentUser().getId();
        return technicalWorkerReps.findByUserId(userId);
    }

}
