package com.service.freelancer.service;

import com.service.base.service.BaseServiceImpl;
import com.service.freelancer.mapper.EngineeringOfficeMapper;
import com.service.freelancer.model.EngineeringOffice;
import com.service.freelancer.repository.EngineeringOfficeReps;
import com.service.userManagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EngineeringOfficeService extends BaseServiceImpl<EngineeringOffice, Long> {

    private final UserService userService;
    private final EngineeringOfficeReps engineeringOfficeReps;
    private final EngineeringOfficeMapper engineeringOfficeMapper;

    public EngineeringOffice findByUserId(Long userId) {
        if (userId == null) userId = userService.getCurrentUser().getId();
        EngineeringOffice engineeringOffice = engineeringOfficeReps.findByUserId(userId);
        return engineeringOffice;
    }
}
