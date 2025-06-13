package com.service.common.repository;

import com.service.common.model.OrderNumberSeq;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderNumberSeqRepository extends JpaRepository<OrderNumberSeq, Long> {

    @Query(value = """
    SELECT seq.*
    FROM order_number_seq seq
    FOR UPDATE 
    """, nativeQuery = true)
    OrderNumberSeq findNextOrderNumber();
}
