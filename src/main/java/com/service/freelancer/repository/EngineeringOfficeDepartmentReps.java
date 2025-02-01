package com.service.freelancer.repository;

import com.service.base.repository.BaseLkpRepository;
import com.service.freelancer.model.EngineeringOfficeDepartment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EngineeringOfficeDepartmentReps extends BaseLkpRepository<EngineeringOfficeDepartment, Integer> {
    @Query("""
        from EngineeringOfficeDepartment eo where (eo.EngineeringOfficeField.id = :id or eo.EngineeringOfficeField.id is null) AND eo.statusCode = 5
    """)
    List<EngineeringOfficeDepartment> getEngineeringOfficeDepartmentByFieldId(Long id);
}
