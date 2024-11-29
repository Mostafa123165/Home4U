package com.service.userManagement.service;

import com.service.base.service.BaseLkpServiceImpl;
import com.service.userManagement.model.UserType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTypesService extends BaseLkpServiceImpl<UserType,Integer> {

    @Override
    public List<UserType> findAll() {
        return super.findAll();
    }

    @Override
    public UserType insert(UserType entity) {
        return super.insert(entity);
    }

    @Override
    public UserType update(UserType entity) {
        return super.update(entity);
    }
}
