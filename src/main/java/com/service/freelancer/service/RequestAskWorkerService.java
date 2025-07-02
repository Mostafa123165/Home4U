package com.service.freelancer.service;

import com.service.base.service.BaseServiceImpl;
import com.service.freelancer.model.RequestAskWorker;
import com.service.freelancer.repository.RequestAskWorkerReps;
import com.service.userManagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestAskWorkerService extends BaseServiceImpl<RequestAskWorker, Long> {

    private final UserService userService;
    private final RequestAskWorkerReps requestAskWorkerReps;

    @Override
    public RequestAskWorker insert(RequestAskWorker entity) {
        entity.setUser(userService.getCurrentUser());
        return super.insert(entity);
    }

    public List<RequestAskWorker> getByAskId(Long askId) {
        return requestAskWorkerReps.getByAskId(askId);
    }
}
