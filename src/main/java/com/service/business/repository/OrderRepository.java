package com.service.business.repository;

import com.service.base.repository.BaseRepository;
import com.service.business.model.Order;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends BaseRepository<Order, Long> {

    @Query(value = """
    SELECT ord
    FROM Order ord
    join ord.user user
    JOIN FETCH ord.orderDetails
    JOIN FETCH ord.status status
    WHERE user.id = :userId
         AND (:statusCode IS NULL or status.code = :statusCode)
    ORDER BY ord.id DESC
    """)
    List<Order> findByUserIdAndOrderStatus(Long userId,String statusCode);

    @Modifying
    @Query(value = """
    UPDATE orders ord
    SET ord.status_id = (select id from order_status_lkp where code = 'DELIVERED')
    WHERE datediff(current_date(),DATE(ord.created_date)) >= 3; 
    """,nativeQuery = true)
    void updateOldOrdersToDelivered();
}

