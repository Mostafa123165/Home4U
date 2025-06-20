package com.service.business.repository;

import com.service.base.repository.BaseRepository;
import com.service.business.dto.ProductRatingResponseDTO;
import com.service.business.model.ProductRating;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


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

    @EntityGraph(attributePaths = {"user", "product"})
    @Query(value = """
        SELECT new com.service.business.dto.ProductRatingResponseDTO(
           rate.id,
           user.id,
           user.firstName,
           user.lastName,
           user.personalPhoto,
           rate.createdDate,
           rate.rate,
           rate.comment)
        FROM ProductRating rate
        JOIN rate.user user
        JOIN rate.product product
        WHERE (:productId IS NULL OR product.id = :productId)
        AND (:stars IS NULL OR rate.rate = :stars)
        ORDER BY
        CASE WHEN :isTopRated IS TRUE THEN rate.rate ELSE NULL END DESC
            ,rate.createdDate DESC
    """)
    Page<ProductRatingResponseDTO> findAllByFilters(
            Long productId,
            Double stars,
            boolean isTopRated,
            Pageable pageable
    );


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Query(value = """
    SELECT rate.rate
    FROM ProductRating rate
    WHERE rate.id =  :productRateId
    """)
    Double getProductRateById(Long productRateId);
}


