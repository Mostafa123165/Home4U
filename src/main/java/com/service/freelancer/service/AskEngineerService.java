package com.service.freelancer.service;

import com.service.base.service.BaseServiceImpl;
import com.service.freelancer.model.AskEngineer;
import com.service.userManagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AskEngineerService extends BaseServiceImpl<AskEngineer, Long> {

    private final UserService userService;

    @Override
    public AskEngineer insert(AskEngineer entity) {
        entity.setUser(userService.getCurrentUser());
        return super.insert(entity);
    }

    @Override
    public AskEngineer update(AskEngineer entity) {
        entity.setUser(userService.getCurrentUser());
        return super.update(entity);
    }
}
