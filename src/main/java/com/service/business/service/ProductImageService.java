package com.service.business.service;

import com.service.business.model.ProductImage;
import com.service.business.repository.ProductImageReps;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductImageService {

    private final ProductImageReps productImageReps;

    public List<ProductImage> saveAll(List<ProductImage> productImages) {
        return productImageReps.saveAll(productImages);
    }
}
