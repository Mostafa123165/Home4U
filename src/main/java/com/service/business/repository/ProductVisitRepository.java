package com.service.business.repository;

import com.service.base.repository.BaseRepository;
import com.service.business.model.ProductVisit;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductVisitRepository extends BaseRepository<ProductVisit, Long> {

    @Query(value = """
    SELECT product.id
    FROM ProductVisit visit
    JOIN visit.user user
    JOIN visit.product product
    WHERE user.id = :userId
    """)
    List<Long> getProductIdsVisitedByUserId(Long userId);

    @Modifying
    @Query(value = """
    DELETE FROM ProductVisit visit
    WHERE visit.user.id = :userId AND visit.product.id = :productId
    """)
    void deleteTheLastVisitByUserId(Long userId, Long productId);
}
