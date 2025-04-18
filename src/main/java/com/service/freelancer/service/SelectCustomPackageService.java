package com.service.freelancer.service;

import com.service.base.service.BaseServiceImpl;
import com.service.freelancer.model.SelectCustomPackage;
import com.service.userManagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SelectCustomPackageService extends BaseServiceImpl<SelectCustomPackage, Long> {

    private final UserService userService;

    @Override
    public SelectCustomPackage insert(SelectCustomPackage entity) {
        entity.setUser(userService.getCurrentUser());
        return super.insert(entity);
    }

    @Override
    public SelectCustomPackage update(SelectCustomPackage entity) {
        entity.setUser(userService.getCurrentUser());
        return super.update(entity);
    }
}
