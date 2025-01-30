package com.service.freelancer.repository;

import com.service.base.repository.BaseLkpRepository;
import com.service.freelancer.model.EngineerServ;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EngineerServReps extends BaseLkpRepository<EngineerServ, Integer> {

    @Query("select e from EngineerServ e " +
            "where (e.engineerType.id = :id or e.engineerType is null) AND e.statusCode = 5")
    List<EngineerServ> getService(Long id);

    @Query("""
            select es
            from Engineer e join e.engineerServ es  where e.id = :engineerId
        """)
    List<EngineerServ> getEngineerServices(Long engineerId);

    @Modifying
    @Transactional
    @Query(value = """
            DELETE FROM fre_engineer_service
            WHERE engineer_id =:engineerId  AND service_id =:serviceId
        """,nativeQuery = true)
    void deleteEngineerServiceByEngineerIdAndServiceId(Long engineerId, Long serviceId);
}
