package com.service.userManagement.repository;

import com.service.base.repository.BaseLkpRepository;
import com.service.userManagement.model.UserType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserTypeReps extends BaseLkpRepository<UserType,Integer> {

    @Override
    @Query(value = """
    SELECT userType
    FROM  UserType userType
    WHERE userType.statusCode = 5
    """)
    List<UserType> findAll();
}
