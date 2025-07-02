package com.service.freelancer.service;

import com.service.base.service.BaseServiceImpl;
import com.service.freelancer.model.RequestHomeRenovate;
import com.service.freelancer.repository.RequestHomeRenovateReps;
import com.service.userManagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestHomeRenovateService extends BaseServiceImpl<RequestHomeRenovate, Long> {

    private final UserService userService;
    private final RequestHomeRenovateReps requestHomeRenovateReps;

    @Override
    public RequestHomeRenovate insert(RequestHomeRenovate entity) {
        entity.setUser(userService.getCurrentUser());
        return super.insert(entity);
    }

    public List<RequestHomeRenovate> getByAskId(Long askId) {
        return requestHomeRenovateReps.getByAskId(askId);
    }
}
