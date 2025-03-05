package com.service.business.controller;

import com.service.base.model.SuccessResponseList;
import com.service.business.dto.ProductImageDto;
import com.service.business.mapper.ProductImageMapper;
import com.service.business.model.Product;
import com.service.business.model.ProductImage;
import com.service.business.service.ProductImageService;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Schema(name = "Product Image" )
@RequestMapping("api/v1/product-images")
public class ProductImageController {

    private final ProductImageService productImageService;
    private final ProductImageMapper productImageMapper;

    @PostMapping("/all")
    public ResponseEntity<?> saveAll(@RequestBody List<ProductImageDto> list) {
        List<ProductImage> entity = productImageMapper.unMap(list);
        productImageService.saveAll(entity);
        return ResponseEntity.ok(new SuccessResponseList<>(productImageMapper.map(entity)));
    }
}
