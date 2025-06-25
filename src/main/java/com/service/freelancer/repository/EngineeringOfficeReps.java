package com.service.freelancer.repository;

import com.service.base.repository.BaseRepository;
import com.service.freelancer.model.EngineeringOffice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EngineeringOfficeReps extends BaseRepository<EngineeringOffice, Long> {
    @Query("""
                from EngineeringOffice w
                where w.user.id = :userId
                """)
    EngineeringOffice findByUserId(Long userId);

    @Query("""
                FROM EngineeringOffice engineeringOffice
                JOIN engineeringOffice.user user
                JOIN user.governorate governorate
                JOIN user.city city
                JOIN engineeringOffice.engineeringOfficeDepartments engineeringOfficeDepartment
                JOIN engineeringOffice.engineeringOfficeField engineeringOfficeField
                WHERE
                    (:governorateId IS NULL OR governorate.id = :governorateId) AND
                    (:cityId IS NULL OR city.id = :cityId) AND
                    (:engineeringOfficeDepartmentId IS NULL OR engineeringOfficeDepartment.id = :engineeringOfficeDepartmentId) AND
                    (:engineeringOfficeFieldId IS NULL OR engineeringOfficeField.id = :engineeringOfficeFieldId) AND
                    (:rate IS NULL OR engineeringOffice.averageRate >= :rate)
                ORDER BY engineeringOffice.averageRate DESC
            """)
    Page<EngineeringOffice> filterTop(Number governorateId, Number cityId, Number engineeringOfficeFieldId, Number engineeringOfficeDepartmentId, Integer rate, Pageable pageable);
}
