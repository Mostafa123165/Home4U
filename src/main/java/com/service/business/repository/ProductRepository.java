package com.service.business.repository;


import com.service.base.repository.BaseRepository;
import com.service.business.dto.ProductSimpleProjection;
import com.service.business.model.Product;
import org.springframework.data.domain.Limit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends BaseRepository<Product, Long> {


   @Query(value = """
    SELECT distinct product
    FROM Product product
    JOIN FETCH product.businessType businessType
    LEFT JOIN FETCH product.stocks stock
    LEFT JOIN FETCH stock.color color
    WHERE product.business.id = :businessId
        AND (:name IS NULL OR product.nameAr LIKE CONCAT('%',:name,'%') OR product.nameEn LIKE CONCAT('%',:name,'%'))
        AND (:businessTypeIds IS NULL OR businessType.id in (:businessTypeIds))
        AND (:colorIds IS NULL OR color.id in (:colorIds))
        AND (:minPrice IS NULL OR product.price >= :minPrice)
        AND (:maxPrice IS NULL OR product.price <= :maxPrice)
        AND (:materialIds IS NULL OR EXISTS (
                    SELECT 1 FROM product.materials materials
                    WHERE materials.id IN (:materialIds)
                ))
        AND (:inStock is false OR stock.amount > 0)
    ORDER BY product.id DESC
    """)
    Page<Product> filter(Long businessId, String name, List<Integer> businessTypeIds, List<Integer> colorIds,List<Integer> materialIds, Double minPrice , Double maxPrice,boolean inStock, Pageable pageable);


   @Query(value = """
    SELECT product
    FROM Product product
    JOIN product.businessType buisinessType
    JOIN product.businessTypeCategory businessTypeCategory
    WHERE (:name IS NULL OR product.nameAr LIKE CONCAT('%',:name,'%') OR product.nameEn LIKE CONCAT('%',:name,'%'))
        AND (:materialIds IS NULL OR EXISTS (
                    SELECT 1 FROM product.materials materials
                    WHERE materials.id IN (:materialIds)
                ))
        AND (:colorIds IS NULL OR EXISTS (
                    SELECT 1
                    FROM product.stocks stock
                    JOIN stock.color color
                    WHERE color.id IN (:colorIds)
                ))
        AND (:businessTypeId IS NULL OR buisinessType.id = :businessTypeId)
        AND (:businessTypeCategoryId IS NULL OR businessTypeCategory.id = :businessTypeCategoryId)
        AND (:minPrice IS NULL OR product.price >= :minPrice)
        AND (:maxPrice IS NULL OR product.price <= :maxPrice)
    ORDER BY product.id DESC
    """)
    Page<Product> shopNow(String name, List<Integer> materialIds, List<Integer> colorIds,Integer businessTypeId,Integer businessTypeCategoryId, Double minPrice, Double maxPrice, Pageable pageable);

    @Query("""
    SELECT p FROM Product p LEFT JOIN FETCH p.imagePaths WHERE p.id IN :ids
    """)
    List<Product> findProductsWithImages(List<Long> ids);

    @Query(value = """
    SELECT product.id as id,
           product.name_ar as nameAr,
           product.name_en as nameEn,
           product.price as price, 
           product.count_rates as countRates,
           product.rate as rate,
           category.name_ar  as categoryNameAr,
           category.name_en  as categoryNameEn,
           GROUP_CONCAT(images.image_path) as images,
           salesView.numberOfSales  as numberOfSales,
           salesView.ranking  as productRankBySales,
           CASE 
            WHEN salesView.ranking <= 10
            THEN 1 ELSE 0
           END     
           as isBestSeller
    FROM products product
    JOIN business_type_category_lkp category on category.id = product.business_type_category_id
    LEFT JOIN product_ranking_by_sales_view salesView on salesView.product_id = product.id
    LEFT JOIN product_images images on images.product_id = product.id
    WHERE product.business_type_category_id IN (:categoryIds)
    GROUP BY product.id
    ORDER BY productRankBySales DESC,RAND()
    limit 10
    """,nativeQuery = true)
    List<ProductSimpleProjection> recommendedProducts(List<Long> categoryIds);

    @Query(value = """
    SELECT DISTINCT category.id
    FROM Product product
    JOIN product.businessTypeCategory category
    WHERE product.id IN (:productIds)
    """)
    List<Long> getBusinessTypeCategoryIdsByProductIds(List<Long> productIds);

    @Query(value = """
    SELECT product.id as id,
           product.name_ar as nameAr,
           product.name_en as nameEn,
           product.price as price, 
           product.count_rates as countRates,
           product.rate as rate,
           category.name_ar  as categoryNameAr,
           category.name_en  as categoryNameEn,
           GROUP_CONCAT(images.image_path) as images,
           salesView.numberOfSales  as numberOfSales,
           salesView.ranking  as productRankBySales,
           CASE 
            WHEN salesView.ranking <= 10
            THEN 1 ELSE 0
           END     
           as isBestSeller
    FROM products product
    JOIN business_type_category_lkp category on category.id = product.business_type_category_id
    LEFT JOIN product_ranking_by_sales_view salesView on salesView.product_id = product.id
    LEFT JOIN product_images images on images.product_id = product.id
    GROUP BY product.id  
    ORDER BY product.rate DESC
    LIMIT 10    
    """,nativeQuery = true)
   List<ProductSimpleProjection> getHighestRatedProducts();


    @Query(value = """
    SELECT product.id as id,
           product.name_ar as nameAr,
           product.name_en as nameEn,
           product.price as price, 
           product.count_rates as countRates,
           product.rate as rate,
           category.name_ar  as categoryNameAr,
           category.name_en  as categoryNameEn,
           GROUP_CONCAT(images.image_path) as images,
           salesView.numberOfSales  as numberOfSales,
           salesView.ranking  as productRankBySales,
           TRUE as isBestSeller
    FROM products product
    JOIN business_type_category_lkp category on category.id = product.business_type_category_id
    LEFT JOIN product_ranking_by_sales_view salesView on salesView.product_id = product.id
    LEFT JOIN product_images images on images.product_id = product.id
    WHERE salesView.ranking <= 10
    GROUP BY product.id  
    LIMIT 10    
    """,nativeQuery = true)
    List<ProductSimpleProjection> getTopBestSellerProducts();
}
