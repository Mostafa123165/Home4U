package com.service.business.repository;


import com.service.base.repository.BaseRepository;
import com.service.business.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends BaseRepository<Product, Long> {


   @Query(value = """
    SELECT product
    FROM Product product
    JOIN FETCH product.businessType
    LEFT JOIN FETCH product.stocks stock
    LEFT JOIN FETCH stock.color
    WHERE product.business.id = :businessId
    ORDER BY product.createdDate DESC
    """)
    Page<Product> filter(Long businessId, Pageable pageable);
}
