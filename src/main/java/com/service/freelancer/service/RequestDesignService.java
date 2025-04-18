package com.service.freelancer.service;

import com.service.base.service.BaseServiceImpl;
import com.service.freelancer.model.RequestDesign;
import com.service.userManagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RequestDesignService extends BaseServiceImpl<RequestDesign, Long> {

    private final UserService userService;

    @Override
    public RequestDesign insert(RequestDesign entity) {
        entity.setUser(userService.getCurrentUser());
        return super.insert(entity);
    }

    @Override
    public RequestDesign update(RequestDesign entity) {
        entity.setUser(userService.getCurrentUser());
        return super.update(entity);
    }

}
