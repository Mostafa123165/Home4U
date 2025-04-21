package com.service.freelancer.repository;

import com.service.base.repository.BaseRepository;
import com.service.freelancer.model.SelectCustomPackage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SelectCustomPackageReps extends BaseRepository<SelectCustomPackage, Long> {

    @Query("""
    FROM SelectCustomPackage SelectCustomPackage
        JOIN SelectCustomPackage.unitType unitType
        JOIN SelectCustomPackage.customPackage cutomPackage
        JOIN SelectCustomPackage.user user
    WHERE
        (:userId IS NULL OR user.id = :userId) AND
        (:unitTypeId IS NULL OR unitType.id = :unitTypeId) AND
        (:customPackageId IS NULL OR cutomPackage.id = :customPackageId) AND
        (:isInsideCompound IS NULL OR SelectCustomPackage.isInsideCompound = :isInsideCompound)
    """)
    Page<SelectCustomPackage> filter(Long userId, Integer unitTypeId, Integer customPackageId, Boolean isInsideCompound, Pageable pageable);
}
