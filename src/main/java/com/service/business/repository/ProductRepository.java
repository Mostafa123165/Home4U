package com.service.business.repository;


import com.service.base.repository.BaseRepository;
import com.service.business.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends BaseRepository<Product, Long> {


   @Query(value = """
    SELECT product
    FROM Product product
    JOIN FETCH product.businessType businessType
    LEFT JOIN FETCH product.stocks stock
    LEFT JOIN FETCH stock.color color
    WHERE product.business.id = :businessId
        AND (:name IS NULL OR product.nameAr LIKE concat('%',:name,'%') OR product.nameEn = :name)
        AND (:businessTypeIds IS NULL OR businessType.id in (:businessTypeIds))
        AND (:colorIds IS NULL OR color.id in (:colorIds))
        AND (:minPrice IS NULL OR product.price >= :minPrice)
        AND (:maxPrice IS NULL OR product.price <= :maxPrice)
        AND (:materialIds IS NULL OR EXISTS (
                    SELECT 1 FROM product.materials materials
                    WHERE materials.id IN (:materialIds)
                ))
        AND (:inStock is false OR stock.amount > 0)
    ORDER BY product.createdDate DESC
    """)
    Page<Product> filter(Long businessId, String name, List<Integer> businessTypeIds, List<Integer> colorIds,List<Integer> materialIds, Double minPrice , Double maxPrice,boolean inStock, Pageable pageable);
}
