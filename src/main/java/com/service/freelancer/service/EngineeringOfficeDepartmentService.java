package com.service.freelancer.service;

import com.service.base.service.BaseLkpServiceImpl;
import com.service.freelancer.model.EngineeringOffice;
import com.service.freelancer.model.EngineeringOfficeDepartment;
import com.service.freelancer.repository.EngineeringOfficeDepartmentReps;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EngineeringOfficeDepartmentService extends BaseLkpServiceImpl<EngineeringOfficeDepartment, Integer> {

    private final EngineeringOfficeDepartmentReps engineeringOfficeDepartmentReps;

    private final EngineeringOfficeService engineeringOfficeService;

    public List<EngineeringOfficeDepartment> getEngineeringOfficeDepartmentByFieldId(Long id) {
        return engineeringOfficeDepartmentReps.getEngineeringOfficeDepartmentByFieldId(id);
    }

    public List<EngineeringOfficeDepartment> getEngineeringOfficeDepartment(Long engineeringOfficeId) {
        return engineeringOfficeDepartmentReps.getEngineeringOfficeDepartment(engineeringOfficeId);
    }

    public void updateOwnEngineeringOfficeDepartments(Long userId, List<EngineeringOfficeDepartment> engineeringOfficeDepartments) {
        EngineeringOffice engineeringOffice = engineeringOfficeService.findByUserId(userId);
        engineeringOffice.setEngineeringOfficeDepartments(engineeringOfficeDepartments);
        engineeringOfficeService.update(engineeringOffice);
    }

    public void deleteByEngineeringOfficeIdAndEngineeringOfficeDepartmentId(Long engineeringOfficeId, Long engineeringOfficeDepartmentId) {
        engineeringOfficeDepartmentReps.deleteEngineerServiceByEngineerIdAndServiceId(engineeringOfficeId, engineeringOfficeDepartmentId);
    }
}
