package com.service.business.repository;

import com.service.business.model.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductImageReps extends JpaRepository<ProductImage,Long> {
}
