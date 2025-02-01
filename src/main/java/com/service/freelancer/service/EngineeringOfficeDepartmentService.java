package com.service.freelancer.service;

import com.service.base.service.BaseLkpServiceImpl;
import com.service.freelancer.model.EngineeringOfficeDepartment;
import com.service.freelancer.repository.EngineeringOfficeDepartmentReps;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EngineeringOfficeDepartmentService extends BaseLkpServiceImpl<EngineeringOfficeDepartment, Integer> {

    private final EngineeringOfficeDepartmentReps engineeringOfficeDepartmentReps;

    public List<EngineeringOfficeDepartment> getEngineeringOfficeDepartmentByFieldId(Long id) {
        return engineeringOfficeDepartmentReps.getEngineeringOfficeDepartmentByFieldId(id);
    }
}
