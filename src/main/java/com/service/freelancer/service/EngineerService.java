package com.service.freelancer.service;

import com.service.auth.service.AuthService;
import com.service.base.Constant;
import com.service.base.service.BaseServiceImpl;

import com.service.freelancer.model.Engineer;
import com.service.freelancer.repository.EngineerReps;
import com.service.userManagement.model.User;
import com.service.userManagement.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EngineerService extends BaseServiceImpl<Engineer, Long> {

    private final EngineerReps engineerReps;


    private final UserService userService;
    private final AuthService authService;

    @Override
    public Engineer insert(Engineer entity) {
        if(entity.getStatusCode() == null)
            entity.setStatusCode(Constant.StatusCodeEnum.DRAFT.getCode());
        return engineerReps.save(entity);
    }
}
