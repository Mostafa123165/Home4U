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

    private final EngineerReps engineerReps;
    private final UserService userService;

    @Override
    public Engineer insert(Engineer entity) {
        return engineerReps.save(entity);
    }
}
