package com.service.freelancer.service;

import com.service.base.service.BaseServiceImpl;
import com.service.freelancer.model.RequestSelectCustomPackage;
import com.service.freelancer.repository.RequestSelectCustomPackageReps;
import com.service.userManagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestSelectCustomPackageService extends BaseServiceImpl<RequestSelectCustomPackage, Long> {

    private final UserService userService;
    private final RequestSelectCustomPackageReps requestSelectCustomPackageReps;

    @Override
    public RequestSelectCustomPackage insert(RequestSelectCustomPackage entity) {
        entity.setUser(userService.getCurrentUser());
        return super.insert(entity);
    }

    public List<RequestSelectCustomPackage> getByAskId(Long askId) {
        return requestSelectCustomPackageReps.getByAskId(askId);
    }
}

