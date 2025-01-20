package com.service.userManagement.service;

import com.service.base.service.BaseServiceImpl;
import com.service.common.service.MessageSourceService;
import com.service.error.RecordNotFoundException;
import com.service.file.FileStorageService;
import com.service.userManagement.model.User;
import com.service.userManagement.repository.UserReps;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService extends BaseServiceImpl<User,Long>   {

    private final UserReps userReps;
    private final MessageSourceService messageSourceService;
    private final FileStorageService fileStorageService;


    public User getCurrentUser() {
        return (User) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
    }

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

    public void addPersonalPhoto(MultipartFile image) {
        User user = getCurrentUser();
         user.setPersonalPhoto(fileStorageService.addPersonalPhoto(image,user.getId()));
         userReps.save(user);
    }
}
