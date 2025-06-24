package com.service.business.repository;

import com.service.base.repository.BaseRepository;
import com.service.business.model.ProductVisit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductVisitRepository extends BaseRepository<ProductVisit, Long> {

    @Query("SELECT pv FROM ProductVisit pv WHERE pv.product.id = :productId")
    List<ProductVisit> findByProductId(Long productId);

    @Query("SELECT pv FROM ProductVisit pv WHERE pv.user.id = :userId")
    List<ProductVisit> findByUserId(Long userId);

    boolean existsByProductIdAndUserId(Long productId, Long userId);
}
