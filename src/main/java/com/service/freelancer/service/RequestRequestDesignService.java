package com.service.freelancer.service;

import com.service.base.service.BaseServiceImpl;
import com.service.freelancer.model.RequestRequestDesign;
import com.service.freelancer.repository.RequestRequestDesignReps;
import com.service.userManagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestRequestDesignService extends BaseServiceImpl<RequestRequestDesign, Long> {

    private final UserService userService;
    private final RequestRequestDesignReps requestRequestDesignReps;

    @Override
    public RequestRequestDesign insert(RequestRequestDesign entity) {
        entity.setUser(userService.getCurrentUser());
        return super.insert(entity);
    }

    public List<RequestRequestDesign> getByAskId(Long askId) {
        return requestRequestDesignReps.getByAskId(askId);
    }
}
