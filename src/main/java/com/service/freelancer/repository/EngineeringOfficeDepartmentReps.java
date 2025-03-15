package com.service.freelancer.repository;

import com.service.base.repository.BaseLkpRepository;
import com.service.freelancer.model.EngineeringOfficeDepartment;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EngineeringOfficeDepartmentReps extends BaseLkpRepository<EngineeringOfficeDepartment, Integer> {
    @Query("""
        from EngineeringOfficeDepartment eo where (eo.EngineeringOfficeField.id = :id or eo.EngineeringOfficeField.id is null) AND eo.statusCode = 5
    """)
    List<EngineeringOfficeDepartment> getEngineeringOfficeDepartmentByFieldId(Long id);

    @Query("""
            select ed
            from EngineeringOffice e join e.engineeringOfficeDepartments ed  where e.id = :engineeringOfficeId
        """)
    List<EngineeringOfficeDepartment>  getEngineeringOfficeDepartment(Long engineeringOfficeId);

    @Modifying
    @Transactional
    @Query(value = """
            DELETE FROM fre_engineering_office_department
            WHERE engineering_office_id =:engineeringOfficeId  AND department_id =:engineeringOfficeDepartmentId
        """,nativeQuery = true)
    void deleteEngineerServiceByEngineerIdAndServiceId(Long engineeringOfficeId, Long engineeringOfficeDepartmentId);
}
