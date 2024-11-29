package com.service.userManagement.service;

import com.service.base.service.BaseServiceImpl;
import com.service.common.service.MessageSourceService;
import com.service.error.RecordNotFoundException;
import com.service.userManagement.model.User;
import com.service.userManagement.repository.UserReps;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService extends BaseServiceImpl<User,Long>   {

    private final UserReps userReps;
    private final MessageSourceService messageSourceService;

    public User findByEmail(String email) {
        return userReps.findByEmail(email)
                .orElseThrow(() -> new RecordNotFoundException(messageSourceService.getMessage("exception.notfound.record")));
    }

    public User findByPhone(String phone) {
        return userReps.findByPhone(phone)
                .orElseThrow(() -> new RecordNotFoundException(messageSourceService.getMessage("exception.notfound.record")));
    }

    public Optional<User> getByEmail(String email) {
        return userReps.findByEmail(email);
    }

    public Optional<User> getByPhone(String phone) {
        return userReps.findByPhone(phone);
    }

}
