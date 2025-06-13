package com.service.business.repository;

import com.service.base.repository.BaseRepository;
import com.service.business.model.ProductRating;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRatingRepository extends BaseRepository<ProductRating, Long> {

    @Query(value = """
    SELECT exists (
    SELECT rate
    FROM ProductRating rate
    JOIN rate.product product
    JOIN rate.user user
    WHERE product.id = :productId AND user.id = :userId
    )
    """)
    boolean existsByProductIdAndUserId(Long productId, Long userId);
}
