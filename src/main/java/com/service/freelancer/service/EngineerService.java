package com.service.freelancer.service;

import com.service.base.service.BaseServiceImpl;
import com.service.freelancer.model.Engineer;
import com.service.freelancer.repository.EngineerReps;
import com.service.userManagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EngineerService extends BaseServiceImpl<Engineer, Long> {

    private final UserService userService;

    private final EngineerReps engineerReps;

    public Engineer findByUserId(Long userId) {
        if (userId == null) userId = userService.getCurrentUser().getId();
        return engineerReps.findByUserId(userId);
    }
}