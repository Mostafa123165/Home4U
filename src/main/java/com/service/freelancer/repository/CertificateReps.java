package com.service.freelancer.repository;

import com.service.base.repository.BaseRepository;
import com.service.freelancer.dto.CertificateDto;
import com.service.freelancer.model.Certificate;
import com.service.freelancer.model.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CertificateReps extends BaseRepository<Certificate, Long> {
    @Query("""
            select c from Certificate c where c.user.id = :userId
            """)
    List<Certificate> findByUserId(Long userId);
}
