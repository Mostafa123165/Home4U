package com.service.userManagement.repository;


import com.service.base.repository.BaseRepository;
import com.service.userManagement.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserReps extends BaseRepository<User,Long> {

    Optional<User> findByEmail(String email);

    Optional<User> findByPhone(String phone);
}

