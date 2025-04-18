package com.service.freelancer.service;

import com.service.base.service.BaseServiceImpl;
import com.service.freelancer.model.CustomPackage;
import com.service.freelancer.model.RequestDesign;
import com.service.userManagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomPackageService extends BaseServiceImpl<CustomPackage, Long> {

    private final UserService userService;

    @Override
    public CustomPackage insert(CustomPackage entity) {
        entity.setUser(userService.getCurrentUser());
        return super.insert(entity);
    }

    @Override
    public CustomPackage update(CustomPackage entity) {
        entity.setUser(userService.getCurrentUser());
        return super.update(entity);
    }
}
