package com.service.userManagement.repository;

import com.service.base.repository.BaseLkpRepository;
import com.service.userManagement.model.UserType;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTypeReps extends BaseLkpRepository<UserType,Integer> {
}
