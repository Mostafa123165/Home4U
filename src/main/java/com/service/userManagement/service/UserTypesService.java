package com.service.userManagement.service;

import com.service.base.service.BaseLkpServiceImpl;
import com.service.userManagement.model.UserType;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTypesService extends BaseLkpServiceImpl<UserType,Integer> {

    @Override
    @Cacheable(value = "user_type", key = "#root.methodName")
    public List<UserType> findAll() {
        return super.findAll();
    }

    @Override
    @CacheEvict(value = "user_type", allEntries = true)
    public UserType insert(UserType entity) {
        return super.insert(entity);
    }

    @Override
    @CacheEvict(value = "user_type", allEntries = true)
    public UserType update(UserType entity) {
        return super.update(entity);
    }
}
