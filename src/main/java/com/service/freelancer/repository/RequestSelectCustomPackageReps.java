package com.service.freelancer.repository;

import com.service.base.repository.BaseRepository;
import com.service.freelancer.model.RequestSelectCustomPackage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestSelectCustomPackageReps extends BaseRepository<RequestSelectCustomPackage, Long> {
    @Query("""
            FROM RequestSelectCustomPackage r
            join r.selectCustomPackage a
            WHERE a.id = :askId
            """)
    List<RequestSelectCustomPackage> getByAskId(Long askId);
}