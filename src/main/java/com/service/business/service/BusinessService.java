package com.service.business.service;

import com.service.base.service.BaseServiceImpl;
import com.service.business.model.Business;
import com.service.business.repository.BusinessReps;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BusinessService extends BaseServiceImpl<Business,Long> {

    private final BusinessReps businessReps;

    public Business findByUserId(Long id) {
        return businessReps.findByUserId(id);
    }
}
