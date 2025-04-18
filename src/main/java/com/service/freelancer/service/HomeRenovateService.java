package com.service.freelancer.service;

import com.service.base.service.BaseServiceImpl;
import com.service.freelancer.model.HomeRenovate;
import com.service.userManagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HomeRenovateService extends BaseServiceImpl<HomeRenovate, Long> {

    private final UserService userService;

    @Override
    public HomeRenovate insert(HomeRenovate entity) {
        entity.setUser(userService.getCurrentUser());
        return super.insert(entity);
    }

    @Override
    public HomeRenovate update(HomeRenovate entity) {
        entity.setUser(userService.getCurrentUser());
        return super.update(entity);
    }

}
