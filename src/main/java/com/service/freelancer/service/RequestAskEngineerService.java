package com.service.freelancer.service;

import com.service.base.service.BaseServiceImpl;
import com.service.freelancer.model.RequestAskEngineer;
import com.service.freelancer.repository.RequestAskEngineerReps;
import com.service.userManagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestAskEngineerService extends BaseServiceImpl<RequestAskEngineer, Long> {

    private final UserService userService;
    private final RequestAskEngineerReps requestAskEngineerReps;

    @Override
    public RequestAskEngineer insert(RequestAskEngineer entity) {
        entity.setUser(userService.getCurrentUser());
        return super.insert(entity);
    }

    public List<RequestAskEngineer> getByAskId(Long askId) {
        return requestAskEngineerReps.getByAskId(askId);
    }
}
